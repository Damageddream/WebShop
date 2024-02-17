package com.webshop.shop.model.product.phoneParts;

import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.model.product.electronicTypes.ElectronicTypes;

public enum Camera {
    MP_200("200 megapixels", 400),
    MP_100("100 megapixels", 300),
    MP_50("50 megapixels", 150);

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    Camera(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public static Camera createFromInt(int choice) throws NoSuchOptionException {
        try{
            return Camera.values()[choice];
        } catch(ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("No option by id "+choice);
        }
    }
    public static void printCameras(){
        for (Camera value : Camera.values()) {
            System.out.println(value.name+" - "+value.ordinal());
        }
    }
}
