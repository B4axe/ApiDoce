package com.example.apidoce.Models;


public class ItemEntity {

    private String nameItem;
    private int quantityItem;
    private double price;
    private double totalPrice;
    private String image;

    public ItemEntity() {
    }

    public ItemEntity(String nameItem, int quantityItem, double price, double totalPrice, String image) {
        this.nameItem = nameItem;
        this.quantityItem = quantityItem;
        this.price = price;
        this.totalPrice = totalPrice;
        this.image=image;
    }

    public ItemEntity(String nameItem, int quantityItem, double price, String image) {
        this.nameItem = nameItem;
        this.quantityItem = quantityItem;
        this.price = price;
        this.image = image;
        this.totalPrice = quantityItem * price;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public int getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
        this.totalPrice = price * quantityItem;
    }


    public void setPrice(double price) {
        this.price = price;
        this.totalPrice = price * quantityItem;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
