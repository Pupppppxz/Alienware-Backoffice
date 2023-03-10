package com.softwaretesting.alienware.repositories.product;

import com.softwaretesting.alienware.dto.CreateProductDTO;
import com.softwaretesting.alienware.models.ProductModel;

import java.util.List;
import java.util.UUID;

public interface CustomProductRepository {
    ProductModel getProductInformationById(UUID id);
    Boolean checkProductExistById(UUID id);
    Boolean checkProductExist(ProductModel product);
    Boolean deleteProduct(UUID id);
    ProductModel createProduct(CreateProductDTO product);
    List<ProductModel> getAll();
}
