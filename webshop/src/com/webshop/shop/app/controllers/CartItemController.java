package com.webshop.shop.app.controllers;

import com.webshop.shop.app.controllers.options.CartItemMenu;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.product.Product;

public class CartItemController {
    private ConsolePrinter printer;
    private DataReader dataReader;
    private Product product;
    private Cart cart;

    public CartItemController(ConsolePrinter printer, DataReader dataReader, Product product, Cart cart) {
        this.printer = printer;
        this.dataReader = dataReader;
        this.product = product;
        this.cart = cart;
    }

    public void cartItemLoop(){
        CartItemMenu option;
        do{
            CartItemMenu.printCartItemMenu(printer);
            option = CartItemMenu.getOption(dataReader, printer);
            switch (option) {
                case GO_BACK -> {
                    printer.printLine("Go Back");
                }
                case UPDATE -> {
                    update();
                    option = CartItemMenu.GO_BACK;
                }
                case DELETE -> {
                    delete();
                    option = CartItemMenu.GO_BACK;
                }
            }
        }while (option != CartItemMenu.GO_BACK);
    }
    private void update(){
        cart.updateProduct(product,dataReader);
    }
    private void delete(){
        cart.removeProduct(product);
    }
}
