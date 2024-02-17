package com.webshop.shop.model.product.computerParts;

public enum RAM {
    CORSAIR("Corsair Vengeance LPX (DDR4)", 105),
    G_SKILL("G.Skill Trident Z5 RGB (DDR5)", 909),
    KINGSTONE("Kingston Fury Beast RGB (DDR5)", 369),
    TEAMGROUP("Teamgroup T-Force Delta RGB (DDR5)", 400);
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    RAM(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
