package com.softwaretesting.alienware.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class CategoryController {
    
    @GetMapping("/category")
    public ResponseEntity<Category> getCategory(@RequestBody Category newCategory) {
        return new ResponseEntity<Category>(newCategory,HttpsStatus.OK);
    }
}
