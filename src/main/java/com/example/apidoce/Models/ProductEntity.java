package com.example.apidoce.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produto")
public class ProductEntity {

    @Id
    private String id;
    private double price;
    private String name;
    private String category;
    private String description;
    private int stock;

    public ProductEntity() {
    }

    public ProductEntity(String id, double price, String name, String category, String description, int stock) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.category = category;
        this.description = description;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
