package com.webshop.shop.app.controllers;

import com.webshop.shop.app.controllers.options.MainMenu;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.warehouse.Warehouse;

public class ShopController {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);

    private Cart cart;
    private Warehouse warehouse;

    public ShopController(){
        cart = new Cart();
        warehouse = new Warehouse();
    }

    public void mainLoop(){
        MainMenu option;
        do{
            MainMenu.printMainMenu(printer);
            option = MainMenu.getOption(dataReader.getInt(), printer);
            switch (option) {
                case EXIT -> {
                    System.out.println("exit");
                }
                case SELECT_COMPUTER -> {
                    selectComputer(cart, warehouse);
                }
                case SELECT_SMARTPHONE -> {
                    System.out.println("select mob");
                }
                case SELECT_ELECTRONIC -> {
                    System.out.println("select ele");
                }
                case CART -> {
                    System.out.printf("cart");
                }
            }
        }while(option != MainMenu.EXIT);
    }
    private void selectComputer(Cart cart, Warehouse warehouse){
        ComputerController computerController = new ComputerController(printer, dataReader, cart, warehouse);
        computerController.computerLoop();
    }
    private void selectSmartphone(){
        SmartphoneController smartphoneController = new SmartphoneController();
    }

    private void selectElectronic(){
        ElectronicController electronicController = new ElectronicController();
    }

    private void cart(){
        CartController cartController = new CartController();
    }

}
