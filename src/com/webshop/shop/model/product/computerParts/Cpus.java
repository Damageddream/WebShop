package com.webshop.shop.model.product.computerParts;

import com.webshop.shop.exception.NoSuchOptionException;

public enum Cpus  {
    I5("Intel Core i5-13600K", 950),
    RYZEN("AMD Ryzen 5 7600X", 920),
    I9("Intel Core i9-13900K", 2500),
    I7("AMD Ryzen 9 7950X", 2440);
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    Cpus(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public static Cpus createFromInt(int choice) throws NoSuchOptionException {
        try{
            return Cpus.values()[choice];
        } catch(ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("No option by id "+choice);
        }
    }

    public static void printCpus(){
        for (Cpus value : Cpus.values()) {
            System.out.println(value.name+" - "+value.ordinal());
        }
    }

}
