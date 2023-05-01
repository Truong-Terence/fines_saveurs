package com.example.fines_saveurs.model;

public class Category {

    private int idCategory;
    private String name;


    public Category(int id) {
        this.idCategory = id;
    }

    public Category(int idCategory, String name) {
        this.name = name;
        this.idCategory = idCategory;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {}

    public String getName() {
        return name;
    }

    public int getId() {
        return idCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id_category=" + idCategory +
                ", name='" + name + '\'' +
                '}';
    }
}
