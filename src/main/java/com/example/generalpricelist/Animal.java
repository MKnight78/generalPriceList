package com.example.generalpricelist;

public class Animal {

    private int id;
    private String name;
    private String description;
    private String price;



    public Animal(String name, String description, String price, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.price = price;
    }
    public String getName() {
        return name;

    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}