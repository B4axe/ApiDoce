package com.example.apidoce.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "cart")
public class CartEntity {
    @Id
    private String id;
    private List<ItemEntity> itemEntityList;
    private Double total = 0.0;

    public CartEntity() {
        this.itemEntityList = new ArrayList<>();
    }

    public CartEntity(String id, List<ItemEntity> itemEntityList, Double total) {
        this.id = id;
        this.itemEntityList = itemEntityList;
        this.total = total;
    }

    public void addItem(ItemEntity item) {
        this.itemEntityList.add(item);
        updateTotal();
    }

    // Atualizar o total do carrinho
    private void updateTotal() {
        this.total = this.itemEntityList.stream()
                .mapToDouble(ItemEntity::getTotalPrice)
                .sum();
    }


    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemEntity> getItemEntityList() {
        return itemEntityList;
    }

    public void setItemEntityList(List<ItemEntity> itemEntityList) {
        this.itemEntityList = itemEntityList;
        updateTotal();
    }

    public Double getTotal() {
        return total;
    }
}