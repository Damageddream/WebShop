package com.webshop.shop.app.controllers;

import com.webshop.shop.app.controllers.options.CartMenu;
import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.client.Client;
import com.webshop.shop.model.product.Product;

import java.util.InputMismatchException;
import java.util.concurrent.ExecutorService;


public class CartController {

    private ConsolePrinter printer;
    private DataReader dataReader;
    private Cart cart;

    private ExecutorService executor;


    public CartController(ConsolePrinter printer, DataReader dataReader, Cart cart, ExecutorService executor) {
        this.printer = printer;
        this.dataReader = dataReader;
        this.cart = cart;
        this.executor = executor;
    }

    public void cartLoop() {
        CartMenu option;
        do {
            CartMenu.printCartMenu(printer);
            option = CartMenu.getOption(dataReader, printer);
            switch (option) {
                case GO_BACK -> {
                    printer.printLine("go back");
                }
                case DISPLAY_CART -> {
                    try {
                        displayCart();
                    } catch (NoSuchOptionException e) {
                        printer.printLine(e.getMessage());
                    } catch (InputMismatchException e) {
                        printer.printLine("Not an number, try again");
                    }
                }
                case PROCESS_ORDER -> {
                    processOrder();
                }
                default -> printer.printLine("No such option, try again");
            }
        } while (option != CartMenu.GO_BACK);
    }

    void displayCart() throws NoSuchOptionException {
        int option;
        int cartSize = cart.getCartProducts().size();
        do {
            cart.displayCart();
            printer.printLine(cartSize + " - Go Back");
            option = dataReader.getInt();
            if (option > cartSize + 1 || option < 0) {
                throw new NoSuchOptionException("No option, try again");
            } else if (cartSize == 0) {
                option = 0;
            } else {
                selectCartItem(cart.getCartProducts().get(option));
                cartSize = cart.getCartProducts().size();
            }
        } while (option != cartSize);
    }

    void processOrder() {
        Client client = dataReader.readAndCreateUser();
        executor.submit(new OrderProcessor(client, cart));
    }
    void selectCartItem(Product product) {
        CartItemController cartItemController = new CartItemController(printer, dataReader, product, cart);
        cartItemController.cartItemLoop();
    }
}
