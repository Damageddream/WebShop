package com.webshop.shop.model.product.computerParts;

public enum Gpus {
    GEFORCE_4070("Nvidia GeForce RTX 4070 Ti"),
    RADEON_7900("AMD Radeon RX 7900 XT"),
    GEFORCE_3080("Nvidia GeForce RTX 3080"),
    RADEON_6700("AMD Radeon RX 6700 XT");
    private String name;

    Gpus(String name) {
        this.name = name;
    }
}
