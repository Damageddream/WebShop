package com.webshop.shop.app.controllers.options;

import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;

import java.util.InputMismatchException;

public enum CartItemMenu {
    GO_BACK(0, "Go Back"),
    UPDATE(1, "Update Item"),
    DELETE(2, "Delete Item");

    private int value;
    private String description;



    CartItemMenu(int value, String desc) {
        this.value = value;
        this.description = desc;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    static CartItemMenu createFromInt(int option) throws NoSuchOptionException {
        try {
            return CartItemMenu.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("No option by id " + option);
        }
    }

    public static CartItemMenu getOption(DataReader dataReader, ConsolePrinter printer) {
        boolean optionOk = false;
        CartItemMenu option = null;
        while (!optionOk) {
            try {
                int num = dataReader.getInt();
                option = CartItemMenu.createFromInt(num);
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", choose again.");
            } catch (InputMismatchException e) {
                printer.printLine("Your choice is not a number, choose again.");
            }
        }
        return option;
    }

    public static void printCartItemMenu(ConsolePrinter printer) {
        printer.printLine("Choose option: ");
        for (CartItemMenu option : CartItemMenu.values()) {
            printer.printLine(option.toString());
        }
    }
}
