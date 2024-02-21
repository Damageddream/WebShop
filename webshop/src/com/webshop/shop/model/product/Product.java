package com.webshop.shop.model.product;

import com.webshop.shop.model.CsvConvertible;

import java.util.Objects;


/**
 * Represents an abstract base product within the web shop system. Products
 * have core properties such as name, price, quantity, and a unique ID.
 * Subclasses are expected to implement specific price calculation logic.
 *
 * @author Marcin
 * @version 1.0
 */
public abstract class Product implements CsvConvertible {
    private static int idPool = 1;
    private int id;
    private String name;
    private double price;
    private int quantity;
    private int nrInCart;

    @Override
    public String toString() {
        return "Name: " + name +
                " Price: " + price +"$";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(price, product.price) == 0 && quantity == product.quantity && nrInCart == product.nrInCart && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity, nrInCart);
    }

    public int getNrInCart() {
        return nrInCart;
    }

    public void setNrInCart(int nrInCart) {
        this.nrInCart = nrInCart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String name, int quantity) {
        this.id = idPool;
        Product.idPool++;
        this.name = name;
        this.quantity = quantity;
        this.nrInCart = 0;
    }

    public Product(String name, int quantity, int nrInCart) {
        this(name,quantity);
        this.nrInCart = nrInCart;
    }
    /**
     * Calculates the total price for the product, potentially factoring
     * in its quantity or other applicable criteria.
     *
     * @return The calculated total price.
     */
    abstract double calcluatePrice();
    /**
     * Checks the product's availability based on its current quantity.
     *
     * @return {@code true} if the product has a quantity greater than zero,
     *         {@code false} otherwise.
     */
    public boolean isAvailable(){
        if(quantity>0){
            return true;
        }
        return false;
    }

}
