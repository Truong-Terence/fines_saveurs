package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Admin;

import java.util.List;

public interface AdminDao extends GenericDao <Admin, Long> {
    Admin findByEmail(String email);

}
