package com.webshop.shop.model.product.computerParts;

public enum RAM {
    CORSAIR("Corsair Vengeance LPX (DDR4)"),
    G_SKILL("G.Skill Trident Z5 RGB (DDR5)"),
    KINGSTONE("Kingston Fury Beast RGB (DDR5)"),
    TEAMGROUP("Teamgroup T-Force Delta RGB (DDR5)");
    private String name;

    public String getName() {
        return name;
    }

    RAM(String name) {
        this.name = name;
    }
}
