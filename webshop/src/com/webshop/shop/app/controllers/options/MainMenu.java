package com.webshop.shop.app.controllers.options;

import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;

import java.util.InputMismatchException;

public enum MainMenu {
    EXIT(0, "Exit program"),
    SELECT_COMPUTER(1, "Select computer"),
    SELECT_SMARTPHONE(2, "Select smartphone"),
    SELECT_ELECTRONIC(3, "Select electronics"),
    CART(4, "Go to your cart");

    private int value;
    private String description;



    MainMenu(int value, String desc) {
        this.value = value;
        this.description = desc;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    static MainMenu createFromInt(int option) throws NoSuchOptionException {
        try {
            return MainMenu.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("No option by id " + option);
        }
    }

    public static MainMenu getOption(DataReader dataReader, ConsolePrinter printer) {
        boolean optionOk = false;
        MainMenu option = null;
        while (!optionOk) {
            try {
                int num = dataReader.getInt();
                option = MainMenu.createFromInt(num);
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", choose again.");
            } catch (InputMismatchException e) {
                printer.printLine("Your choice is not a number, choose again.");
            }
        }
        return option;
    }

    public static void printMainMenu(ConsolePrinter printer) {
        printer.printLine("Choose option: ");
        for (MainMenu option : MainMenu.values()) {
            printer.printLine(option.toString());
        }
    }
}
