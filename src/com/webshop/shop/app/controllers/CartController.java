package com.webshop.shop.app.controllers;

import com.webshop.shop.app.controllers.options.CartMenu;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.warehouse.Warehouse;

import java.util.InputMismatchException;

public class CartController {

    private ConsolePrinter printer;
    private DataReader dataReader;
    private Cart cart;
    private Warehouse warehouse;

    public CartController(ConsolePrinter printer, DataReader dataReader, Cart cart, Warehouse warehouse) {
        this.printer = printer;
        this.dataReader = dataReader;
        this.cart = cart;
        this.warehouse = warehouse;
    }
    public void cartLoop(){
        CartMenu option;
        do{
            CartMenu.printCartMenu(printer);
            option = CartMenu.getOption(dataReader.getInt(), printer);
            switch (option) {
                case GO_BACK -> {
                    printer.printLine("go back");
                }
                case DISPLAY_CART -> {
                    displayCart();
                }
                case PROCESS_ORDER -> {
                    processOrder();
                }
                default -> printer.printLine("No such option, try again");
            }
        }while (option != CartMenu.GO_BACK);
    }

    void displayCart(){
        int option = 0;
        int cartSize = cart.getCartProducts().size();
        do{
            cart.displayCart();
            printer.printLine(cartSize+" - go back");
            try{
                option = dataReader.getInt();
                if(option > cartSize+1 || option < 0){
                    printer.printLine("No such option, try again");
                 } else if (cartSize == 0) {
                    option = 0;
                } else{
                    if(cart.removeProduct(cart.getCartProducts().get(option))){
                        printer.printLine("Item removed from cart");
                        cartSize = cart.getCartProducts().size();
                    } else {
                        printer.printLine("There is no such product in the cart");
                    }
                }
            }catch(InputMismatchException e){
                printer.printLine("Your choice is not a number, choose again:");
            }
        }while (option != cartSize);
    }
    void processOrder(){

    }
}
