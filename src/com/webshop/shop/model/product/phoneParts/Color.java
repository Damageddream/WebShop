package com.webshop.shop.model.product.phoneParts;

import com.webshop.shop.exception.NoSuchOptionException;

public enum Color  {
    RED("red", 100),
    WHITE("white", 100),

    BLACK("black", 100),
    BLUE("blue", 100),
    GREEN("green",100);

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    Color(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static Color createFromInt(int choice) throws NoSuchOptionException {
        try{
            return Color.values()[choice];
        } catch(ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("No option by id "+choice);
        }
    }

    public static void printColors(){
        for (Color value : Color.values()) {
            System.out.println(value.ordinal()+" - "+value.name);
        }
    }
}
