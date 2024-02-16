package com.webshop.shop.model.product;

import java.util.Objects;
import java.util.Scanner;

public abstract class Product {
    private static int idPool = 0;
    private int id;
    private String name;
    private double price;
    private int quantity;

    @Override
    public String toString() {
        return ", name: '" + name +
                ", price: " + price +"$" +
                ", quantity: " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(price, product.price) == 0 && quantity == product.quantity && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String name, double price, int quantity) {
        this.id = idPool+1;
        Product.idPool += Product.idPool+1;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    abstract void configure();

}
