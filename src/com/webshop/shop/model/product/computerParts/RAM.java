package com.webshop.shop.model.product.computerParts;

import com.webshop.shop.exception.NoSuchOptionException;

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
    public static RAM createFromInt(int choice) throws NoSuchOptionException {
        try{
            return RAM.values()[choice];
        } catch(ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("No option by id "+choice);
        }
    }
    public static void printRAM(){
        for (RAM value : RAM.values()) {
            System.out.println(value.name+" - "+value.ordinal());
        }
    }
}
