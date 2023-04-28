package com.example.fines_saveurs.model;

public class Category {
    private int id_category;
    private String name;

    public Category(int id_category, String name) {
        this.name = name;
        this.id_category = id_category;
    }
    public Category(String name) {
        this.name = name;
    }

    public Category() {}

    public Category(int id) {
        this.id_category = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id_category;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int idCategory) {
        this.id_category = idCategory;
    }
}
