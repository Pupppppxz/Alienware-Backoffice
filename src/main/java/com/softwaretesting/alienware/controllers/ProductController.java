package com.softwaretesting.alienware.controllers;

import com.softwaretesting.alienware.services.ProductService;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    private final ProductService productService;

    ProductController() {
        productService = new ProductService();
    }
}
