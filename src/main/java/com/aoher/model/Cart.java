package com.aoher.model;

import java.util.Set;

public class Cart {

    private long id;
    private double total;
    private Set<Item> items;

    public Cart() {
    }

    public Cart(long id, double total, Set<Item> items) {
        this.id = id;
        this.total = total;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
