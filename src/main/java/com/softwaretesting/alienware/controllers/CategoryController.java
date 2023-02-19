package com.softwaretesting.alienware.controllers;

import com.softwaretesting.alienware.models.CategoryModel;
import com.softwaretesting.alienware.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class CategoryController {

    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/all")
    public ResponseEntity<?> getAllCategory() {
        try {
            List<CategoryModel> categories = categoryService.findAll();
            return ResponseEntity.ok().body(categories);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("something went wrong");
        }
    }

    @GetMapping("/category")
    public ResponseEntity<?> getCategoryById(@RequestParam("id") UUID id) {
        try {
            CategoryModel category = categoryService.findById(id);
            return ResponseEntity.ok().body(category);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("something went wrong");
        }
    }

    @PostMapping("/category/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryModel category) {
        try {
            UUID newCategoryId = categoryService.createCategory(category);
            return ResponseEntity.ok().body(newCategoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("something went wrong");
        }
    }

    @PostMapping("/category/delete")
    public ResponseEntity<?> createCategory(@RequestParam("id") UUID id) {
        try {
            UUID categoryDeletedId = categoryService.deleteById(id);
            return ResponseEntity.ok().body(categoryDeletedId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("something went wrong");
        }
    }

    @PutMapping("/category/update")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryModel newCategory) {
        try {
            UUID categoryUpdatedId = categoryService.update(newCategory);
            return  ResponseEntity.ok().body(categoryUpdatedId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("something went wrong");
        }
    }
}
