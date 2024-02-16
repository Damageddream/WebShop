package com.webshop.shop.model.cart;

import com.webshop.shop.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> cartProducts;
    private double totalPrice;

    public Cart() {
        this.cartProducts = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getCartProducts() {
        return cartProducts;
    }
    public void addProduct(Product product){
        cartProducts.add(product);
        totalPrice += totalPrice + product.getPrice();
    }

    public boolean removeProduct(Product product){
        if(cartProducts.contains(product)){
                cartProducts.remove(product);
                totalPrice -= totalPrice-product.getPrice();
                return true;
        }
        return false;
    }

    public void displayProducts(){
        System.out.println("Right now in your cart are: ");
        cartProducts.forEach(System.out::println);
        System.out.println("and Total price is: "+totalPrice+"$");
    }
}
