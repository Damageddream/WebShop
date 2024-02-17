package com.webshop.shop.model.product.phoneParts;

public enum Color {
    RED("red", 100),
    WHITE("white", 100),

    BLACK("black", 100),
    BLUE("blue", 100),
    GREEN("green",100);

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    Color(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
