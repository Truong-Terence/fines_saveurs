package com.example.fines_saveurs.service;

import com.example.fines_saveurs.dao.AdminDao;
import com.example.fines_saveurs.model.Admin;
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
class AdminServiceTest {

    @Mock
    private AdminDao adminDaoMock;

    @InjectMocks
    private AdminService underTest;

    @Test
    void ShouldReturnTrueIfValidCredentials() {
        String email = "admin@example.com";
        String password = "secret";

        Admin adminFound = new Admin();
        adminFound.setEmail(email);
        adminFound.setPassword(password);

        when(adminDaoMock.findByEmail(email)).thenReturn(adminFound);

        boolean result = underTest.login(email, password);

        assertTrue(result);
    } // login

    @Test
    void ShouldReturnFalseIfInvalidCredentials() {
        String email = "admin@example.com";
        String password = "secret";

        when(adminDaoMock.findByEmail(email)).thenReturn(null);

        boolean result = underTest.login(email, password);

        assertFalse(result);
    } // login

    @Test
    void ShouldReturnAnAdminGivenId() {
        Admin expected = new Admin();
        expected.setEmail("admin@example.com");
        expected.setPassword("secret");

        when(adminDaoMock.findById(any(long.class))).thenReturn(expected);

        Admin result = underTest.fetchAdminById(1);

        assertEquals(expected, result);
    } // fetchAdminById

    @Test
    void ShouldReturnTrueGivenParams() {
        Admin admin = new Admin();
        admin.setEmail("admin@example.com");
        admin.setPassword("secret");
        admin.setFirstname("J");
        admin.setLastname("Doe");

        when(adminDaoMock.create(any(Admin.class))).thenReturn(true);

        boolean result = underTest.addAdmin("", "", "", "");

        assertTrue(result);
    } // addAdmin

    @Test
    void ShouldReturnFalseGivenParams() {
        Admin admin = new Admin();
        admin.setEmail("admin@example.com");
        admin.setPassword("secret");
        admin.setFirstname("J");
        admin.setLastname("Doe");

        when(adminDaoMock.create(any(Admin.class))).thenReturn(false);

        boolean result = underTest.addAdmin("", "", "", "");

        assertFalse(result);
    } // addAdmin

    @Test
    void ShouldReturnAllAdmins() {
        List<Admin> expected = new ArrayList<>();
        expected.add(new Admin("", "", "", ""));
        expected.add(new Admin("", "", "", ""));

        when(adminDaoMock.findAll()).thenReturn(expected);

        List<Admin> result = underTest.fetchAllAdmins();

        assertEquals(expected, result);
    } //fetchAllAdmins

    @Test
    void ShouldReturnAnAdminGivenEmail() {
        Admin expected = new Admin("", "", "", "");

        when(adminDaoMock.findByEmail(any(String.class))).thenReturn(expected);

        Admin result = underTest.getAdminByEmail("");

        assertEquals(expected, result);
    } // fetchAdminByEmail

    @Test
    void ShouldReturnTrueGivenId() {
        Admin admin = new Admin("", "", "", "");

        when(adminDaoMock.delete(any(Admin.class))).thenReturn(true);

        boolean result = underTest.deleteAdmin(1);

        assertTrue(result);
    } // deleteAdmin

    @Test
    void ShouldReturnFalseGivenId() {
        Admin admin = new Admin("", "", "", "");

        when(adminDaoMock.delete(any(Admin.class))).thenReturn(false);

        boolean result = underTest.deleteAdmin(1);

        assertFalse(result);
    } // deleteAdmin

    @Test
    void ShouldUpdateAdmin() {
        Admin admin = new Admin("", "", "", "");

        underTest.updateAdmin(admin);

        verify(adminDaoMock).update(admin);
    } // update

    @Test
    void ShouldReturnAllEmptyCategories() {
        List<Admin> expected = new ArrayList<>();
        expected.add(new Admin("", "", "", ""));
        expected.add(new Admin("", "", "", ""));

        when(adminDaoMock.fetchEmptyAdmins()).thenReturn(expected);

        List<Admin> result = underTest.fetchEmptyAdmins();

        assertEquals(expected, result);
    } // fetchEmptyAdmins
}