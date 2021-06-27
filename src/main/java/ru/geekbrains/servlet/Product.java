package ru.geekbrains.servlet;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String title;
    private BigDecimal cost;

    public Product(int id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("id: %d; title: %s; cost: %s$", id, title, cost);
    }
}
