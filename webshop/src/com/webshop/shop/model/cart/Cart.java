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
/**
 * Represents the customer's shopping cart within the web shop. It stores a
 * list of selected products, calculates the total cart price, and provides
 * functionality for adding, removing, and updating products.
 *
 * @author Marcin
 * @version 1.0
 */
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
    /**
     * Adds a product to the cart. If the product is already included, its quantity
     * is incremented.  The cart's total price is updated.
     *
     * @param product The product to be added to the cart.
     * @throwss error If the product is not currently in stock.
     */
    public void addProduct(Product product) throws ProductUnvaliableException {
        if (product.isAvailable()) {
            if (!cartProducts.contains(product)) {
                cartProducts.add(product);
            }
            product.setNrInCart(product.getNrInCart() + 1);
            product.setQuantity(product.getQuantity() - 1);
            totalPrice += product.getPrice();
        } else {
            throw new ProductUnvaliableException("Product not currently available, choose something else");
        }
    }
    /**
     * Removes a product from the cart. If the product's quantity is greater than
     * one, it decrements the quantity. Otherwise, the product is removed entirely.
     * The total price is adjusted.
     *
     * @param product The product to be removed.
     */
    public void removeProduct(Product product) {
        if (product.getNrInCart() > 1) {
            product.setNrInCart(product.getNrInCart() - 1);
        }else{
            cartProducts.remove(product);
        }
        totalPrice -= product.getPrice();
        System.out.println("item removed");
    }

    public void displayCart() {
        if (cartProducts.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            System.out.println("Choose item to update or delete");
            System.out.println("Right now in your cart are: ");
            cartProducts.forEach(product -> {
                int productIndex = cartProducts.indexOf(product);
                System.out.println(productIndex + " - " + product);
                System.out.println("in cart: "+product.getNrInCart());
            });
            System.out.println("and Total price is: " + totalPrice + "$");
        }
    }
    /**
     * Updates a product in the cart based on user input.  Handles reading new product
     * specifications and replacing the existing product in the cart.
     * Recalculates the total price.
     *
     * @param productToUpdate The existing product in the cart to be modified.
     * @param dataReader A {@code DataReader} object to facilitate user input.
     */
    public void updateProduct(Product productToUpdate, DataReader dataReader) {
        int index = cartProducts.indexOf(productToUpdate);
        Product product = null;
        try {
            if (productToUpdate instanceof Computer) {
                product = dataReader.readAndCreateComputer(productToUpdate.getNrInCart());
            } else if (productToUpdate instanceof Smartphone) {
                product = dataReader.readAndCreateSmartphone(productToUpdate.getNrInCart());
            } else if (productToUpdate instanceof Electronic) {
                product = dataReader.readAndCreateElectronic(productToUpdate.getNrInCart());
            }
            System.out.println("item updated");
        } catch (NoSuchOptionException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Wrong input try again");
        }
        if (product == null) {
            System.out.println("You cannot update empty product");
        } else {
            cartProducts.set(index, product);
            updateTotalPrice();
        }
    }
    private void updateTotalPrice() {
        if (!cartProducts.isEmpty()) {
            double newPrice = 0;
            for (Product product : cartProducts) {
                newPrice += product.getPrice()*product.getNrInCart();
            }
            totalPrice = newPrice;
        }
    }

    public void clear(){
        cartProducts.clear();
        totalPrice = 0;
    }

    @Override
    public String toCsv() {
        return null;
    }
}
