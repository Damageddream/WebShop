package com.webshop.shop.model.product;

import com.webshop.shop.model.CsvConvertible;

import java.util.Objects;
import java.util.Scanner;

public abstract class Product implements CsvConvertible {
    private static int idPool = 0;
    private int id;
    private String name;
    private double price;
    private int quantity;

    @Override
    public String toString() {
        return "Name: " + name +
                " Price: " + price +"$";
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

    public Product(String name, int quantity) {
        this.id = idPool+1;
        Product.idPool += Product.idPool+1;
        this.name = name;
        this.quantity = quantity;
    }

    abstract double calcluatePrice();

    public boolean isAvailable(){
        if(quantity>0){
            return true;
        }
        return false;
    }

}
