package com.webshop.shop.model.product.phoneParts;

import com.webshop.shop.exception.NoSuchOptionException;

public enum Storage  {
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

    public static Storage createFromInt(int choice) throws NoSuchOptionException{
        try{
            return Storage.values()[choice];
        } catch(ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("No option by id "+choice);
        }
    }
    public static void printStorages(){
        for (Storage value : Storage.values()) {
            System.out.println(value.ordinal()+" - "+value.name);
        }
    }
}
