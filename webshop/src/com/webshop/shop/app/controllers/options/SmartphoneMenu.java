package com.webshop.shop.app.controllers.options;

import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;

import java.util.InputMismatchException;

public enum SmartphoneMenu {
    GO_BACK(0, "Go Back"),
    SELECT_PRESET(1, "Select Smartphone"),
    CONFIGURE(2, "Configure your own Smartphone");


    private int value;
    private String description;



    SmartphoneMenu(int value, String desc) {
        this.value = value;
        this.description = desc;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    static SmartphoneMenu createFromInt(int option) throws NoSuchOptionException {
        try {
            return SmartphoneMenu.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("No option by id " + option);
        }
    }

    public static SmartphoneMenu getOption(DataReader dataReader, ConsolePrinter printer) {
        boolean optionOk = false;
        SmartphoneMenu option = null;
        while (!optionOk) {
            try {
                int num = dataReader.getInt();
                option = SmartphoneMenu.createFromInt(num);
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
        for (SmartphoneMenu option : SmartphoneMenu.values()) {
            printer.printLine(option.toString());
        }
    }
}
