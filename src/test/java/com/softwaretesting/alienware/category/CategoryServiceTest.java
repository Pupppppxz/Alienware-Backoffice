package com.softwaretesting.alienware.category;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

import com.softwaretesting.alienware.repositories.category.CategoryRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.softwaretesting.alienware.models.CategoryModel;
import com.softwaretesting.alienware.repositories.category.CategoryRepository;
import com.softwaretesting.alienware.services.CategoryService;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    CategoryRepositoryImpl repository;
    @InjectMocks
    private CategoryService categoryService;

    // get all category
    @Test
    void should_return_all_categories_when_call_findAll_given_number_of_category_in_db_is_not_zero() {
        // Given
        CategoryModel category = new CategoryModel();
        List<CategoryModel> categories = new ArrayList<>();
        categories.add(category);
        when(categoryService.findAll()).thenReturn(categories);
        // When
        List<CategoryModel> actual = categoryService.findAll();
        // Then
        assertFalse(actual.isEmpty());

    }
    @Test
    void should_return_nothing_when_call_findAll_given_nothing_in_db() {
        // Given
        CategoryModel category = new CategoryModel();
        List<CategoryModel> categories = new ArrayList<>();
        when(categoryService.findAll()).thenReturn(categories);
        // When
        List<CategoryModel> actual = categoryService.findAll();
        // Then
        assertTrue(actual.isEmpty());
    }
    // get category by ID
    @Test
    void should_return_category_when_call_findById_given_we_have_that_categoryId_in_db() {
        //Given
        CategoryModel category = new CategoryModel();
        UUID id = UUID.randomUUID();
        when(categoryService.findById(id)).thenReturn(category);
        //When
        CategoryModel actual = categoryService.findById(id);
        //Then
        assertEquals(category,actual);
    }
    @Test
    void should_return_null_when_call_findById_given_we_dont_have_that_categoryId_in_db(){
        //Given
        CategoryModel category = new CategoryModel();
        UUID id = UUID.randomUUID();
        when(categoryService.findById(id)).thenReturn(null);
        //When
        CategoryModel actual = categoryService.findById(id);
        //Then
        assertNull(actual);
    }

    // create new category
    @Test
    void should_return_UUID_when_call_create_category_given_category_has_been_created_in_db_completely() {
        //Given
        CategoryModel category = new CategoryModel();
        UUID uuid = UUID.randomUUID();
        when(repository.create(category)).thenReturn(uuid);

        //When
        UUID actual = categoryService.createCategory(category);
        //Then
        assertEquals(uuid, actual);
    }

    @Test
    void should_return_null_when_call_create_category_given_category_can_not_create_in_db() {
        //Given
        CategoryModel category = new CategoryModel();
        when(repository.create(category)).thenReturn(null);

        //When
        UUID actual = categoryService.createCategory(category);
        //Then
        assertNull(actual);
    }
    // delete category by ID
    @Test
    void should_return_UUID_when_call_deleteById_given_category_that_want_to_delete_exist_in_db_and_has_been_deleted(){
        //Given
        UUID expectedId = UUID.randomUUID();
        when(categoryService.deleteById(expectedId)).thenReturn(expectedId);
        //When
        UUID actual = categoryService.deleteById(expectedId);
        //Then
        assertEquals(expectedId,actual);
    }
    @Test
    void should_return_null_when_call_deleteById_given_category_that_want_to_delete_not_exist_in_db() {
        //Given
        UUID expectedId = UUID.randomUUID();
        when(categoryService.deleteById(expectedId)).thenReturn(null);
        //When
        UUID actual = categoryService.deleteById(expectedId);
        //Then
        assertNull(actual);
    }
    // update category
    @Test
    void should_return_UUID_when_call_update_given_categoryId_that_want_to_update_exist_in_db() {
        //Given
        CategoryModel newCategory = new CategoryModel();
        UUID id = UUID.randomUUID();
        when(categoryService.update(newCategory)).thenReturn(id);
        //When
        UUID actual = categoryService.update(newCategory);
        //Then
        assertNotNull(actual);
    }
    @Test
    void should_return_UUID_when_call_update_given_categoryId_that_want_to_update_dont_exist_in_db() {
        //Given
        CategoryModel newCategory = new CategoryModel();
        when(categoryService.update(newCategory)).thenReturn(null);
        //When
        UUID actual = categoryService.update(newCategory);
        //Then
        assertNull(actual);
    }
}
