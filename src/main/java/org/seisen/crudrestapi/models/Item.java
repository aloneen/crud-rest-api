package org.seisen.crudrestapi.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.seisen.crudrestapi.entity.ItemEntity;

import java.time.LocalDateTime;
import java.util.Date;

public class Item {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private LocalDateTime created_at;

    public Item() {
    }

    public Item(Long id, String name, String description, Double price, LocalDateTime created_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.created_at = created_at;
    }


    public static Item toModel(ItemEntity entity) {
        return new Item(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getCreated_at());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
