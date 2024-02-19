package com.webshop.shop.app.controllers;

import com.webshop.shop.app.controllers.options.ElectronicsMenu;
import com.webshop.shop.app.controllers.options.SmartphoneMenu;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.product.Electronic;
import com.webshop.shop.model.product.Smartphone;
import com.webshop.shop.model.warehouse.Warehouse;

import java.util.List;

public class ElectronicController {
    private ConsolePrinter printer;
    private DataReader dataReader;
    private Cart cart;
    private Warehouse warehouse;

    public ElectronicController(ConsolePrinter printer, DataReader dataReader, Cart cart, Warehouse warehouse) {
        this.printer = printer;
        this.dataReader = dataReader;
        this.cart = cart;
        this.warehouse = warehouse;
    }

    public void electronicsLoop() {
        ElectronicsMenu option;
        do {
            ElectronicsMenu.printComputerMenu(printer);
            option = ElectronicsMenu.getOption(dataReader.getInt(), printer);
            switch (option) {
                case GO_BACK -> {
                    System.out.println("go back");
                }
                case SELECT_PRESET -> {
                    selectPreset();
                }
                default -> System.out.println("No such option, try again");
            }
        } while (option != ElectronicsMenu.GO_BACK);
    }
    private void selectPreset() {
        List<Electronic> electonicsInStock = warehouse.getElectronicsInStock();
        String option;
        do {
            for (int i = 0; i < electonicsInStock.size(); i++) {
                System.out.println(i + " - " + electonicsInStock.get(i));
            }
            System.out.println(5 + " - Go back");
            option = dataReader.getString();
            switch (option) {
                case "0" -> {
                    addToCart(0, electonicsInStock);
                }
                case "1" -> {
                    addToCart(1, electonicsInStock);
                }
                case "2" -> {
                    addToCart(2, electonicsInStock);
                }
                case "3" -> {
                    addToCart(3, electonicsInStock);
                }
                case "4" -> {
                    addToCart(4, electonicsInStock);
                }
                case "5" -> {
                    option = "5";
                }
            }
        } while (!option.equals("5"));
    }
    private void addToCart(int num, List<Electronic> electonicsInStock){
        cart.addProduct(electonicsInStock.get(num));
        System.out.println("Electronic added to cart");
    }
}
