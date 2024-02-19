package com.webshop.shop.app.controllers;

import com.webshop.shop.app.controllers.options.SmartphoneMenu;
import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.product.Smartphone;
import com.webshop.shop.model.warehouse.Warehouse;

import java.util.InputMismatchException;
import java.util.List;

public class SmartphoneController {
    private ConsolePrinter printer;
    private DataReader dataReader;
    private Cart cart;
    private Warehouse warehouse;

    public SmartphoneController(ConsolePrinter printer, DataReader dataReader, Cart cart, Warehouse warehouse) {
        this.printer = printer;
        this.dataReader = dataReader;
        this.cart = cart;
        this.warehouse = warehouse;
    }

    public void smartPhoneLoop() {
        SmartphoneMenu option;
        do {
            SmartphoneMenu.printComputerMenu(printer);
            option = SmartphoneMenu.getOption(dataReader.getInt(), printer);
            switch (option) {
                case GO_BACK -> {
                    System.out.println("go back");
                }
                case SELECT_PRESET -> {
                    selectPreset();
                }
                case CONFIGURE -> {
                    configure();
                }
                default -> System.out.println("No such option, try again");
            }
        } while (option != SmartphoneMenu.GO_BACK);
    }

    private void selectPreset() {
        List<Smartphone> smartphonesInStock = warehouse.getSmartphonesInStock();
        String option;
        do {
            for (int i = 0; i < smartphonesInStock.size(); i++) {
                System.out.println(i + " - " + smartphonesInStock.get(i));
            }
            System.out.println(5 + " - Go back");
            option = dataReader.getString();
            switch (option) {
                case "0" -> {
                    addToCart(0, smartphonesInStock);
                }
                case "1" -> {
                    addToCart(1, smartphonesInStock);
                }
                case "2" -> {
                    addToCart(2, smartphonesInStock);
                }
                case "3" -> {
                    addToCart(3, smartphonesInStock);
                }
                case "4" -> {
                    addToCart(4, smartphonesInStock);
                }
                case "5" -> {
                    option = "5";
                }
            }
        } while (!option.equals("5"));
    }

    private void addToCart(int num, List<Smartphone> smartphonesInStock){
        cart.addProduct(smartphonesInStock.get(num));
        System.out.println("Smartphone added to cart");
    }

    private void configure() {
        boolean working = true;
        while (working) {
            try {
                Smartphone smartphone = dataReader.readAndCreateSmartphone();
                cart.addProduct(smartphone);
                System.out.println("smartphone added to cart");
                working = false;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", try again:");
            } catch (InputMismatchException e) {
                printer.printLine("No number input, try again:");
            }
        }

    }
}