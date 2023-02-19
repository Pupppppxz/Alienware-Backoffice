package com.softwaretesting.alienware.services;

import com.softwaretesting.alienware.dto.CreateProductDTO;
import com.softwaretesting.alienware.models.ProductModel;
import com.softwaretesting.alienware.repositories.product.ProductRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.Suite;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@Suite
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepositoryImpl productRepository;

    ProductModel product1; // valid
    ProductModel product2; // not valid price
    UUID categoryId = UUID.randomUUID();

    @InjectMocks
    ProductService productService = new ProductService();

    @BeforeEach
    void init() {
        product1 = new ProductModel(
                UUID.randomUUID(),
                "product1",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                99.78F,
                90,
                categoryId,
                false
        );
        product2 = null;
    }

    @Test
    void should_return_product_with_product_id_when_call_save_func_given_valid_object() {
        CreateProductDTO dto = new CreateProductDTO(
                "product1",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                99.78F,
                90,
                categoryId
        );
        when(productRepository.createProduct(any(CreateProductDTO.class))).thenReturn(product1);

        ProductModel savedProduct = productService.save(dto);

        Assertions.assertNotNull(savedProduct);
        Assertions.assertNotNull(savedProduct.getProductId());
        Assertions.assertEquals(savedProduct.getName(), product1.getName());
        Assertions.assertEquals(savedProduct.getCategoryId(), product1.getCategoryId());
        Assertions.assertEquals(savedProduct.getPrice(), product1.getPrice());
        Assertions.assertEquals(savedProduct.getDetail(), product1.getDetail());
        Assertions.assertEquals(savedProduct.getActive(), product1.getActive());
    }

    @Test
    void should_return_null_when_call_save_func_given_invalid_object() {
        CreateProductDTO dto = new CreateProductDTO(
                "product1",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                -99.78F,
                90,
                categoryId
        );
        lenient().when(productRepository.createProduct(any(CreateProductDTO.class))).thenReturn(product2);

        ProductModel savedProduct = productService.save(dto);

        Assertions.assertNull(savedProduct);
    }
}