package com.webshop.shop.app.controllers.options;

import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;

import java.util.InputMismatchException;

public enum ElectronicsMenu {
    GO_BACK(0, "Go Back"),
    SELECT_PRESET(1, "Select Electronic");

    private int value;
    private String description;

    ElectronicsMenu(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    static ElectronicsMenu createFromInt(int option) throws NoSuchOptionException {
        try {
            return ElectronicsMenu.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("No option by id " + option);
        }
    }

    public static ElectronicsMenu getOption(DataReader dataReader, ConsolePrinter printer) {
        boolean optionOk = false;
        ElectronicsMenu option = null;
        while (!optionOk) {
            try {
                int num = dataReader.getInt();
                option = ElectronicsMenu.createFromInt(num);
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
        for (ElectronicsMenu option : ElectronicsMenu.values()) {
            printer.printLine(option.toString());
        }
    }
}
