package com.softwaretesting.alienware.category;

import java.util.List;

import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.hibernate.annotations.TimeZoneStorage;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAllCategories() {
        return repository.findAll();
    }
}
