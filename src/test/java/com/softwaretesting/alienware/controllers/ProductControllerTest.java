package com.softwaretesting.alienware.controllers;

import com.softwaretesting.alienware.models.ProductModel;
import com.softwaretesting.alienware.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

//    private final ProductService productService = new ProductService();

    @Test
    void should_return_status_code_201_when_create_product_given_valid_product_object() {
        // given
        ProductModel product = new ProductModel(
                "product1",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                99.78F,
                90,
                UUID.fromString("product1")
        );
        // when

        //then
    }

    @Test
    void getAllProducts() {
        // given

        // when

        //then
    }

    @Test
    void getProductById() {
        // given

        // when

        //then
    }

    @Test
    void deleteProduct() {
        // given

        // when

        //then
    }

    @Test
    void updateProduct() {
        // given

        // when

        //then
    }
}