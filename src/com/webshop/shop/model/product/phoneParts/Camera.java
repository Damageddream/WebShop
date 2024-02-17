package com.webshop.shop.model.product.phoneParts;

public enum Camera {
    MP_200("200 megapixels", 400),
    MP_100("100 megapixels", 300),
    MP_50("50 megapixels", 150);

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    Camera(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
