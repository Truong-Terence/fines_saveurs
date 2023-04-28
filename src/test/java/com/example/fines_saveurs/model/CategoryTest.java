package com.example.fines_saveurs.model;

import com.example.fines_saveurs.service.CategoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    public CategoryTest() {
    MockitoAnnotations.initMocks(this);
}
//    @BeforeEach
//    void setUp() {}
//    @AfterEach
//    void tearDown() {}
    @Test
    void getName() {
    Category category = new Category(1, "testName");

    String name = category.getName();
    assertEquals("testName", name);
    }
    @Test
    void getId() {
        Category category = new Category(1, "testName");
        int id = category.getId();
        assertEquals(1, id);
    }
    @Test
    void setName() {
        Category category = new Category(1, "testName");
        category.setName("newName");
        assertEquals("newName", category.getName());
    }
    @Test
    void setId() {
        Category category = new Category(1, "testName");
        category.setId(2);
        assertEquals(2, category.getId());
    }
}