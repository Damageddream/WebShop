package com.webshop.shop.model.product;

import com.webshop.shop.model.product.electronicTypes.ElectronicTypes;

import java.util.Objects;

public class Electronic extends Product{

    private ElectronicTypes electronic;

    public Electronic(String name, int quantity, ElectronicTypes electronic) {
        super(name, quantity);
        this.electronic = electronic;
        this.setPrice(calcluatePrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Electronic that = (Electronic) o;
        return electronic == that.electronic;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), electronic);
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
