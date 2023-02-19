package com.softwaretesting.alienware.repositories.category;

import com.softwaretesting.alienware.models.CategoryModel;

import java.util.List;
import java.util.UUID;


public interface CategoryRepository {
    List<CategoryModel> findAll();

    CategoryModel findById(UUID id);

    UUID create(CategoryModel category);

    UUID deleteById(UUID id);

    UUID update(CategoryModel newCategory);
}
