package com.example.fines_saveurs.model;

public class Category {
    private int id_category;
    private String name;

    public Category(int id_category, String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
