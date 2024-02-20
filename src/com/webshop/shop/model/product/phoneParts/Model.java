package com.webshop.shop.model.product.phoneParts;

import com.webshop.shop.exception.NoSuchOptionException;

public enum Model  {
    SAMSUNG_GALAXY("Samsung Galaxy s23", 3000),
    APPLE_IPHONE("Apple Iphone 14", 4000),
    HUAWEI_MATE("Huawei Mate 60 pro", 2500),
    XIAOMI_REDMI("Xiaomi Redmi 12", 1500);

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    Model(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public static Model createFromInt(int choice) throws NoSuchOptionException {
        try{
            return Model.values()[choice];
        } catch(ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("No option by id "+choice);
        }
    }
    public static void printModels(){
        for (Model value : Model.values()) {
            System.out.println(value.ordinal()+" - "+value.name);
        }
    }
}
