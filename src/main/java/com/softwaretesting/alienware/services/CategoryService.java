package com.softwaretesting.alienware.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.softwaretesting.alienware.models.CategoryModel;
import com.softwaretesting.alienware.repositories.category.CategoryRepository;
import com.softwaretesting.alienware.repositories.category.CategoryRepositoryImpl;
import org.hibernate.annotations.TimeZoneStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepositoryImpl repository;
    @Autowired
    public CategoryService(CategoryRepositoryImpl repository) {
        this.repository = repository;
    }

    //get
    public List<CategoryModel> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public CategoryModel findById(UUID id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //post
    public UUID createCategory(CategoryModel category) {
        try {
            return repository.create(category);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //delete
    public UUID deleteById(UUID id) {
        try {
            return repository.deleteById(id);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //update
    public UUID update(CategoryModel newCategory) {
        try {
            return repository.update(newCategory);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }






}
