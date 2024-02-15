package com.webshop.shop.model.product.computerParts;

public enum Harddrives {
    BARRACUDA("Seagate Barracuda"),
    WESTERN("Western Digital Blue"),
    SAMSUNG("Samsung 870 QVO"),
    FIRECUDE("Seagate FireCuda");

    private String name;

    public String getName() {
        return name;
    }

    Harddrives(String name) {
        this.name = name;
    }
}
