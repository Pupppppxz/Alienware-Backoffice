package com.softwaretesting.alienware.repositories.product;

import com.softwaretesting.alienware.models.ProductInformation;
import com.softwaretesting.alienware.models.ProductModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.UUID;

public interface CustomProductRepository {
    ProductInformation getProductInformationById(UUID id);
    Boolean checkProductExistById(UUID id);
    Boolean checkProductExist(ProductModel product);
    Boolean deleteProduct(UUID id);
    ProductModel createProduct(ProductModel product);
    List<ProductInformation> getAll();
}
