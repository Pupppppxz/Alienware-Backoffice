package com.softwaretesting.alienware.category;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class CategroyServiceTest {

    @Mock
    CategoryRepository repository;
    
    @InjectMocks
    private CategoryService categoryService;

    @Test
    void should_return_all_categories_when_call_findAll() {
        // Given
        // When
        List<Category> categories = categoryService.findAllCategories();
        // Then
     
        verify(repository,times(1)).findAll();
    }

    void should_return_category_that_id_as_same_as_id_parameter() {
        // Given
        // When
        List<Category> categories = categoryService.findAllCategories();
        // Then
    }
}
