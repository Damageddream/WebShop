package com.webshop.shop.model.cart;

import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.exception.ProductUnvaliableException;
import com.webshop.shop.io.DataReader;
import com.webshop.shop.model.CsvConvertible;
import com.webshop.shop.model.product.Computer;
import com.webshop.shop.model.product.Electronic;
import com.webshop.shop.model.product.Product;
import com.webshop.shop.model.product.Smartphone;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

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
            totalPrice += product.getPrice();
        }else{
            throw new ProductUnvaliableException("Product not currently available, choose something else");
        }
    }

    public void removeProduct(Product product){
        if(cartProducts.contains(product)){
                cartProducts.remove(product);
                totalPrice -= product.getPrice();
        }else{
            System.out.println("No such product in cart");
        }
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

    public void updateProduct(Product productToUpdate, DataReader dataReader){
        int index = cartProducts.indexOf(productToUpdate);
        Product product = null;
        try{
            if(productToUpdate instanceof Computer){
                product = dataReader.readAndCreateComputer();
            }
            else if (productToUpdate instanceof Smartphone){
                product = dataReader.readAndCreateSmartphone();
            } else if (productToUpdate instanceof Electronic) {
                product = dataReader.readAndCreateElectronic();
            }
        }catch (NoSuchOptionException e){
            System.out.println(e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Wrong input try again");
        }
        if(product == null){
            System.out.println("You cannot update empty product");
        }else{
            cartProducts.set(index, product);
            updateTotalPrice();
        }
    }

    private void updateTotalPrice(){
        if(!cartProducts.isEmpty()){
            double newPrice = 0;
            for (Product product : cartProducts) {
                newPrice += product.getPrice();
            }
            totalPrice = newPrice;
            }
        }

    @Override
    public String toCsv() {
        return null;
    }
}
