package com.webshop.shop.model.product;

import com.webshop.shop.model.product.electronicTypes.ElectronicTypes;

public class Electronic extends Product{

    private ElectronicTypes electronic;

    public Electronic(String name, int quantity, ElectronicTypes electronic) {
        super(name, quantity);
        this.electronic = electronic;
        this.setPrice(calcluatePrice());
    }



    @Override
    double calcluatePrice() {
        return electronic.getPrice();
    }

    @Override
    public String toString() {
        return super.toString() +"\n"
                +"Details: "+electronic.getName();
    }

    @Override
    public String toCsv() {
        return electronic.getName()+";"+
                getName()+";"+
                getPrice()+";";
    }
}
