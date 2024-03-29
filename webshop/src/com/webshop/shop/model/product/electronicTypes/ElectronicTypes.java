package com.webshop.shop.model.product.electronicTypes;

import com.webshop.shop.exception.NoSuchOptionException;


public enum ElectronicTypes  {
    MOUSE("Logitech G305 Lightspeed", 229),
    KEYBOARD("SteelSeries Apex 3 TKL", 250),
    HEADPHONES("Logitech G PRO X", 429),
    MICROPHONE("Silver Monkey X", 100),
    CAMERA("Logitech C920 Pro Full HD", 370);
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    ElectronicTypes(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static ElectronicTypes createFromInt(int choice) throws NoSuchOptionException {
        try{
            return ElectronicTypes.values()[choice];
        } catch(ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("No option by id "+choice);
        }
    }
    public static void printElectronicTypes(){
        for (ElectronicTypes value : ElectronicTypes.values()) {
            System.out.println(value.ordinal()+" - "+value.name);
        }
    }
}
