package com.aoher.model;

import javax.persistence.*;

@Entity
@Table(name = "ItemMM")
public class Item1 {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "item_price")
    private double price;

    @Column(name = "item_desc")
    private String description;

    public Item1() {
    }

    public Item1(long id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
