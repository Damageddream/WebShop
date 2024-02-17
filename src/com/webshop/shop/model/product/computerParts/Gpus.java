package com.webshop.shop.model.product.computerParts;

import com.webshop.shop.exception.NoSuchOptionException;

public enum Gpus {
    GEFORCE_4070("Nvidia GeForce RTX 4070 Ti", 3099),
    RADEON_7900("AMD Radeon RX 7900 XT", 1650),
    GEFORCE_3080("Nvidia GeForce RTX 3080", 1260),
    RADEON_6700("AMD Radeon RX 6700 XT", 1650);
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    Gpus(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public static Gpus createFromInt(int choice) throws NoSuchOptionException {
        try{
            return Gpus.values()[choice];
        } catch(ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("No option by id "+choice);
        }
    }
    public static void printGpus(){
        for (Gpus value : Gpus.values()) {
            System.out.println(value.name+" - "+value.ordinal());
        }
    }
}
