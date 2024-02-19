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
                    printer.printLine("exit");
                }
                case SELECT_COMPUTER -> {
                    selectComputer();
                }
                case SELECT_SMARTPHONE -> {
                   selectSmartphone();
                }
                case SELECT_ELECTRONIC -> {
                    selectElectronic();
                }
                case CART -> {
                    cart();
                }
            }
        }while(option != MainMenu.EXIT);
    }
    private void selectComputer(){
        ComputerController computerController = new ComputerController(printer, dataReader, cart, warehouse);
        computerController.computerLoop();
    }
    private void selectSmartphone(){
        SmartphoneController smartphoneController = new SmartphoneController(printer, dataReader, cart, warehouse);
        smartphoneController.smartPhoneLoop();
    }

    private void selectElectronic(){
        ElectronicController electronicController = new ElectronicController(printer, dataReader, cart, warehouse);
        electronicController.electronicsLoop();
    }

    private void cart(){
        CartController cartController = new CartController(printer, dataReader, cart, warehouse);
        cartController.cartLoop();
    }

}
