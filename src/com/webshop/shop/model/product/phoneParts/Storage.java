package com.webshop.shop.model.product.phoneParts;

public enum Storage {
    GB_64("64 gigabytes", 200),
    GB_128("128 gigabytes", 250),
    GB_256("256 gigabytes", 300),
    GB_512("512 gigabytes", 350);

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    Storage(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
