package com.softwaretesting.alienware.controllers;

import com.softwaretesting.alienware.dto.CreateProductDTO;
import com.softwaretesting.alienware.models.CustomHttpResponse;
import com.softwaretesting.alienware.models.ProductModel;
import com.softwaretesting.alienware.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product")
    @ResponseBody
    public ResponseEntity<?> createProduct(@RequestBody (required=false) CreateProductDTO dto) {
        try {
            ProductModel product = this.productService.save(dto);
            if (product == null) {
                return new ResponseEntity<>(new CustomHttpResponse(
                        "Invalid request body",
                        400
                ), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(new CustomHttpResponse(
                    "Created",
                    201
            ), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @GetMapping(value = "/products")
    public ResponseEntity<?> getAllProducts() {
        try {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "/product?id={productId}")
    public ResponseEntity<?> getProductById(@RequestParam UUID id) {
        try {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping(value = "/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID productId) {
        try {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping(value = "/product")
    public ResponseEntity<?> updateProduct(@RequestBody ProductModel product) {
        try {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
