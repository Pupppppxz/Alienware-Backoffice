package com.softwaretesting.alienware.repositories.product;

import com.softwaretesting.alienware.dto.CreateProductDTO;
import com.softwaretesting.alienware.models.ProductModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements CustomProductRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ProductModel getProductInformationById(UUID id) {
        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT p.\"ProductId\", p.\"Name\", p.\"Detail\", p.\"Price\", p.\"Quantity\"" +
                            ", p.\"IsActive\", p.\"CreatedAt\", p.\"UpdatedAt\", c.\"Name\"\n" +
                            "FROM public.\"Products\" p\n" +
                            "LEFT JOIN public.\"Categories\" c\n" +
                            "ON p.\"CategoryId\" = c.\"CategoryId\"\n" +
                            "WHERE p.\"ProductId\" = ?",
                    ProductModel.class
            );
            query.setParameter(1, id);
            System.out.println(query.getResultList());
            if (query.getFirstResult() == 0) {
                return null;
            }
            return (ProductModel) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean checkProductExistById(UUID id) {
        return null;
    }

    @Override
    public Boolean checkProductExist(ProductModel product) {
        return null;
    }

    @Override
    public Boolean deleteProduct(UUID id) {
        try {
            Query query = entityManager.createQuery(
                "UPDATE public.\"Products\"\n" +
                        "\tSET \"DeletedAt\"=now()\n" +
                        "\tWHERE \"ProductId\" = ?;"
            );
            query.setParameter(1, id);
            if (query.executeUpdate() == 0) return false;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public ProductModel createProduct(CreateProductDTO product) {
        try {
            Query query = entityManager.createNativeQuery(
                    "INSERT INTO public.\"Products\"(\n" +
                            "\t\"Name\", \"Detail\", \"Price\", \"Quantity\", \"IsActive\", \"CategoryId\")\n" +
                            "\tVALUES (?, ?, ?, ?, ?, ?)\n" +
                            "\tRETURNING \"ProductId\";",
                    UUID.class
            );
            query.setParameter(1, product.getName());
            query.setParameter(2, product.getDetail());
            query.setParameter(3, product.getPrice());
            query.setParameter(4, product.getQuantity());
            query.setParameter(5, false);
            query.setParameter(6, product.getCategoryId().toString());
            System.out.println(query.getResultList().get(0));
            ProductModel productSaved = new ProductModel(
                    (UUID) query.getResultList().get(0),
                    product.getName(),
                    product.getDetail(),
                    product.getPrice(),
                    product.getQuantity(),
                    product.getCategoryId(),
                    false
            );
            return productSaved;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<ProductModel> getAll() {
        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT p.\"ProductId\", p.\"Name\", p.\"Detail\", p.\"Price\", p.\"Quantity\"" +
                            ", p.\"IsActive\", p.\"CreatedAt\", p.\"UpdatedAt\", c.\"Name\"\n" +
                            "FROM public.\"Products\" p\n" +
                            "LEFT JOIN public.\"Categories\" c\n" +
                            "ON p.\"CategoryId\" = c.\"CategoryId\"\n",
                    ProductModel.class
            );

            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
