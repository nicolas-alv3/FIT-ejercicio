package com.fit.exercise.model;

import javax.persistence.Entity;

@Entity
public class Product extends EntityId{
    private Double price;
    private String description;
    private String name;

    public Product(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product() {

    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
}
