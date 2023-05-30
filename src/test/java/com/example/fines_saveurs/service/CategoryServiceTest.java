package com.example.fines_saveurs.service;

import com.example.fines_saveurs.dao.CategoryDao;
import com.example.fines_saveurs.model.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryDao categoryDaoMock;

    @InjectMocks
    private CategoryService underTest;

    @Test
    void ShouldReturnAllCategories() {


        List<Category> expected = new ArrayList<>();
        expected.add(new Category(1, "category1"));
        expected.add(new Category(2, "category2"));

        when(categoryDaoMock.findAll()).thenReturn(expected);

        List<Category> result = underTest.fetchAllCategories();

        assertEquals(expected, result);
    } //fetchAllCategories

    @Test
    void ShouldReturnTrueGivenAName() {
        Category category = new Category();
        category.setName("categoryTest");

        when(categoryDaoMock.create(any(Category.class))).thenReturn(true);

        boolean result = underTest.addCategory("");

        assertEquals(true, result);
    }  // addCategory

    @Test
    void ShouldReturnFalseGivenAName() {
        Category category = new Category();
        category.setName("categoryTest");

        when(categoryDaoMock.create(any(Category.class))).thenReturn(false);

        boolean result = underTest.addCategory("categoryTest");

        assertFalse(result);
    } // addCategory

    @Test
    void ShouldReturnACategory() {
        Category expected = new Category();
        expected.setName("categoryTest");

        when(categoryDaoMock.findById(any(int.class))).thenReturn(expected);

        Category result = underTest.getById(1);

        assertEquals(expected, result);
    } // getById

    @Test
    void ShouldReturnTrueGivenId() {
        Category category = new Category();
        category.setName("categoryTest");

        when(categoryDaoMock.delete(any(Category.class))).thenReturn(true);

        boolean result = underTest.deleteCategory(1);

        assertEquals(true, result);
    } // deleteCategory

    @Test
    void ShouldReturnFalseGivenId() {
        Category category = new Category();
        category.setName("categoryTest");

        when(categoryDaoMock.delete(any(Category.class))).thenReturn(false);

        boolean result = underTest.deleteCategory(1);

        assertEquals(false, result);
    } // deleteCategory

    @Test
    void ShouldUpdateCategory() {
        Category category = new Category();
        category.setName("categoryTest");

        underTest.updateCategory(category);

        verify(categoryDaoMock).update(category);
    } // update

    @Test
    void ShouldReturnAllEmptyCategories() {
        List<Category> expected = new ArrayList<>();
        expected.add(new Category(1, "category1"));
        expected.add(new Category(2, "category2"));

        when(categoryDaoMock.fetchEmptyCategories()).thenReturn(expected);

        List<Category> result = underTest.fetchEmptyCategories();

        assertEquals(expected, result);
    } // fetchEmptyCategories
}