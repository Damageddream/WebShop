package com.webshop.shop.model.product.computerParts;

public enum Cpus {
    I5("Intel Core i5-13600K"),
    RYZEN("AMD Ryzen 5 7600X"),
    I9("Intel Core i9-13900K"),
    I7("AMD Ryzen 9 7950X");
    private String name;

    public String getName() {
        return name;
    }

    Cpus(String name) {
        this.name = name;
    }
}
