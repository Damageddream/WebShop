package com.webshop.shop.app.controllers.options;

import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;

import java.util.InputMismatchException;

public enum ComputerMenu {

    GO_BACK(0, "Go Back"),
    SELECT_PRESET(1, "Select preset Computer"),
    CONFIGURE(2, "Configure your own Computer");


    private int value;
    private String description;



    ComputerMenu(int value, String desc) {
        this.value = value;
        this.description = desc;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    static ComputerMenu createFromInt(int option) throws NoSuchOptionException {
        try {
            return ComputerMenu.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("No option by id " + option);
        }
    }

    public static ComputerMenu getOption(DataReader dataReader, ConsolePrinter printer) {
        boolean optionOk = false;
        ComputerMenu option = null;
        while (!optionOk) {
            try {
                int num = dataReader.getInt();
                option = ComputerMenu.createFromInt(num);
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", choose again.");
            } catch (InputMismatchException e) {
                printer.printLine("Your choice is not a number, choose again.");
            }
        }
        return option;
    }

    public static void printComputerMenu(ConsolePrinter printer) {
        printer.printLine("Choose option: ");
        for (ComputerMenu option : ComputerMenu.values()) {
            printer.printLine(option.toString());
        }
    }
}
