package com.webshop.shop.model.cart;

import com.webshop.shop.exception.ProductUnvaliableException;
import com.webshop.shop.model.CsvConvertible;
import com.webshop.shop.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart implements CsvConvertible {

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
    public void addProduct(Product product) throws ProductUnvaliableException {
        if(product.isAvailable()){
            cartProducts.add(product);
            product.setQuantity(product.getQuantity()-1);
            totalPrice += totalPrice + product.getPrice();
        }else{
            throw new ProductUnvaliableException("Product not currently available, choose something else");
        }
    }

    public boolean removeProduct(Product product){
        if(cartProducts.contains(product)){
                cartProducts.remove(product);
                totalPrice -= totalPrice-product.getPrice();
                return true;
        }
        return false;
    }

    public void displayCart(){
        if(cartProducts.isEmpty()){
            System.out.println("Cart is empty");
        } else {
            System.out.println("Right now in your cart are: ");

            cartProducts.forEach(product -> {
                int productIndex = cartProducts.indexOf(product);
                System.out.println(productIndex+" - "+product);
            });
            System.out.println("and Total price is: "+totalPrice+"$");
        }
    }

    @Override
    public String toCsv() {
        return null;
    }
}
