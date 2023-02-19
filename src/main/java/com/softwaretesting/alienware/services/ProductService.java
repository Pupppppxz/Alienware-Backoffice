package com.softwaretesting.alienware.services;

import com.softwaretesting.alienware.dto.CreateProductDTO;
import com.softwaretesting.alienware.exception.InvalidBodyException;
import com.softwaretesting.alienware.models.ProductModel;
import com.softwaretesting.alienware.repositories.product.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductService {

    @Autowired
    private ProductRepositoryImpl productRepository;

    public boolean validateProductObject(CreateProductDTO dto) {
        try {
            if (dto.getName().isEmpty() ||
                    dto.getCategoryId() == null ||
                    dto.getDetail().isEmpty() ||
                    dto.getPrice() <= 0 ||
                    dto.getQuantity() < 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ProductModel save(CreateProductDTO dto) {
        try {
            if (!this.validateProductObject(dto)) {
                throw new InvalidBodyException();
            }
            ProductModel productSaved = this.productRepository.createProduct(dto);
            return productSaved;
        } catch (InvalidBodyException e) {
            return null;
        }
    }

    public List<ProductModel> findAll() {
        try {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ProductModel getById(UUID id) {
        try {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteById(UUID id) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(ProductModel productModel) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
