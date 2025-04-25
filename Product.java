package com.pluralsight;

public class Product {
    private int id;
    private String name, department;
    private Double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;

        this.department = "";
    }

    public Product(String splitItem, String splitItem1, double price, String splitItem2) {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return id + " | " + name + " | $" + price + " | " + department;
    }
}

