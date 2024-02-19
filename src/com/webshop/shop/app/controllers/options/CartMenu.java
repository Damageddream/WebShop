package com.webshop.shop.app.controllers.options;

import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.io.ConsolePrinter;

import java.util.InputMismatchException;

public enum CartMenu {
    GO_BACK(0, "Go Back"),
    DISPLAY_CART(1, "Display cart / remove from cart"),
    PROCESS_ORDER(2, "Process order");


    private int value;
    private String description;

    CartMenu(int value, String description) {
        this.value = value;
        this.description = description;
    }
    @Override
    public String toString() {
        return value + " - " + description;
    }

    static CartMenu createFromInt(int option) throws NoSuchOptionException {
        try {
            return CartMenu.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("No option by id " + option);
        }
    }

    public static CartMenu getOption(int num, ConsolePrinter printer) {
        boolean optionOk = false;
        CartMenu option = null;
        while (!optionOk) {
            try {
                option = CartMenu.createFromInt(num);
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", choose :");
            } catch (InputMismatchException ignored) {
                printer.printLine("Your choice is not a number, choose again:");
            }
        }
        return option;
    }
    public static void printCartMenu(ConsolePrinter printer) {
        printer.printLine("Choose option: ");
        for (CartMenu option : CartMenu.values()) {
            printer.printLine(option.toString());
        }
    }
}
