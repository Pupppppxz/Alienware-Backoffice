package com.softwaretesting.alienware.repositories.product;

import com.softwaretesting.alienware.models.ProductInformation;
import com.softwaretesting.alienware.models.ProductModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements CustomProductRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ProductInformation getProductInformationById(UUID id) {
        return null;
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
        return null;
    }

    @Override
    public ProductModel createProduct(ProductModel product) {
        return null;
    }

    @Override
    public List<ProductInformation> getAll() {
        return null;
    }
}
