package com.example.fines_saveurs.model;

public class Category {

    private int id;
    private String name;


    public Category(int id) {
        this.id = id;
    }

    public Category(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {}

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getInt(String id) {
        return this.id;
    }

    public String getString(String name) {
        return this.name;
    }
}
