package com.webshop.shop.model.product.computerParts;

import com.webshop.shop.exception.NoSuchOptionException;

public enum Harddrives {
    BARRACUDA("Seagate Barracuda", 280),
    WESTERN("Western Digital Blue", 970),
    SAMSUNG("Samsung 870 QVO", 2700),
    FIRECUDE("Seagate FireCuda", 339);

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    Harddrives(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public static Harddrives createFromInt(int choice) throws NoSuchOptionException {
        try{
            return Harddrives.values()[choice];
        } catch(ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("No option by id "+choice);
        }
    }

    public static void printHarddrives(){
        for (Harddrives value : Harddrives.values()) {
            System.out.println(value.ordinal()+" - "+value.name);
        }
    }
}
