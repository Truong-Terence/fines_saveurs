package com.example.fines_saveurs.service;

import com.example.fines_saveurs.dao.AdminDao;
import com.example.fines_saveurs.dao.ProductDao;
import com.example.fines_saveurs.model.Admin;
import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.model.Product;
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
class ProductServiceTest {
    @Mock
    private ProductDao productDaoMock;

    @InjectMocks
    private ProductService underTest;


    @Test
    void ShouldReturnTrueGivenParams() {
        String name = "Product 1";
        String brand = "Brand";
        String ref = "ABC123";
        int stock = 10;
        String description = "Description";
        String ingredients = "Ingredients";
        String conditioning = "Conditioning";
        String origin = "Origin";
        double price = 9.99;
        String fileName = "product1.jpg";
        Category category = new Category(1);

        when(productDaoMock.create(any(Product.class))).thenReturn(true);

        boolean result = underTest.addProduct(name, brand, ref, stock, description, ingredients, conditioning, origin, price, fileName, category);

        assertTrue(result);
    } // addProduct

    @Test
    void ShouldReturnFalseGivenParams() {
        String name = "Product 1";
        String brand = "Brand";
        String ref = "ABC123";
        int stock = 10;
        String description = "Description";
        String ingredients = "Ingredients";
        String conditioning = "Conditioning";
        String origin = "Origin";
        double price = 9.99;
        String fileName = "product1.jpg";
        Category category = new Category(1);

        when(productDaoMock.create(any(Product.class))).thenReturn(false);

        boolean result = underTest.addProduct(name, brand, ref, stock, description, ingredients, conditioning, origin, price, fileName, category);

        assertFalse(result);
    } // addProduct

    @Test
    void ShouldReturnAllProducts() {
        List<Product> expected = new ArrayList<>();
        expected.add(new Product(1, "", "", "", 1, "", "", "", "", "", 1, new Category(1, "")));
        expected.add(new Product(1, "", "", "", 1, "", "", "", "", "", 1, new Category(1, "")));

        when(productDaoMock.findAll()).thenReturn(expected);

        List<Product> result = underTest.fetchAllProducts();

        assertEquals(expected, result);
    } // fetchAllProducts

    @Test
    void ShouldReturnAllProductsGivenACategory() {
        List<Product> expected = new ArrayList<>();
        expected.add(new Product(1, "", "", "", 10, "", "", "", "", "", 1, new Category(1)));
        expected.add(new Product(2, "", "", "", 5, "", "", "", "", "", 1, new Category(1)));

        when(productDaoMock.findByCategory(1)).thenReturn(expected);

        List<Product> result = underTest.fetchProductsByCategory(1);

        assertEquals(expected, result);
    } //fetchProductsByCategory

    @Test
    void ShouldReturnProductGivenId() {
        Product expected = new Product(1, "", "", "", 1, "", "", "", "", "", 1, new Category(1));

        when(productDaoMock.findById(1)).thenReturn(expected);

        Product result = underTest.fetchProductById(1);

        assertEquals(expected, result);
    } // fetchProductById

    @Test
    void ShouldReturnTrueGivenId() {
        Product product = new Product(1, "", "", "", 10, "", "", "", "", "", 1, new Category(1));

        when(productDaoMock.delete(any(Product.class))).thenReturn(true);

        boolean result = underTest.deleteProduct(1);

        assertTrue(result);
    } // deleteProduct


    @Test
    void ShouldReturnFalseGivenId() {
        Product product = new Product(1, "", "", "", 10, "", "", "", "", "", 1, new Category(1));

        when(productDaoMock.delete(any(Product.class))).thenReturn(false);

        boolean result = underTest.deleteProduct(1);

        assertFalse(result);
    } // deleteProduct


    @Test
    void ShouldUpdateProduct() {
        int productId = 1;
        String name = "Product";
        String brand = "Brand";
        int stock = 5;
        String description = "Description";
        String ingredients = "Ingredients";
        String conditioning = "Conditioning";
        String origin = "Origin";
        double price = 1;
        int categoryId = 2;

        Category category = new Category(categoryId);
        Product updatedProduct = new Product(productId, name, brand, stock, description, ingredients, conditioning, origin, price, category);

        when(productDaoMock.findById(productId)).thenReturn(updatedProduct);

        Product result = underTest.updateProduct(productId, name, brand, stock, description, ingredients, conditioning, origin, price, categoryId);

        assertEquals(updatedProduct, result);
    }
 // updateProduct

    @Test
    void ShouldReturnAllProductGivenKeywords() {
        String keyword = "keyword";

        List<Product> expected = new ArrayList<>();
        expected.add(new Product(1, "", "", "", 10, "", "", "", "", "", 1, new Category(1)));
        expected.add(new Product(2, "", "", "", 5, "", "", "", "", "", 1, new Category(2)));

        when(productDaoMock.fetchByKeywords(any(String.class))).thenReturn(expected);

        List<Product> result = underTest.searchByKeywords(keyword);

        assertEquals(expected, result);
    } // searchByKeywords


    @Test
    void ShouldReturnTrueGivenImageAndId() {
        int productId = 1;
        String filename = "new_image.jpg";

        when(productDaoMock.updateImage(productId, filename)).thenReturn(true);

        boolean result = underTest.changeImage(productId, filename);

        assertTrue(result);
    } // changeImage


    @Test
    void ShouldReturnFalseeGivenImageAndId() {
        int productId = 1;
        String filename = "new_image.jpg";

        when(productDaoMock.updateImage(productId, filename)).thenReturn(false);

        boolean result = underTest.changeImage(productId, filename);

        assertFalse(result);
    } // changeImage
}