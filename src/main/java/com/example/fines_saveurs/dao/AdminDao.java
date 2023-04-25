package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Admin;

public interface AdminDao extends GenericDao <Admin, Long> {
    Admin findByEmail(String email);
}
