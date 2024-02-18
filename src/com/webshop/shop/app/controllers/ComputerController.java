package com.webshop.shop.app.controllers;

import com.webshop.shop.app.controllers.options.ComputerMenu;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.product.Computer;
import com.webshop.shop.model.warehouse.Warehouse;

import java.util.List;

public class ComputerController {

    private ConsolePrinter printer;
    private DataReader dataReader;
    private Cart cart;
    private Warehouse warehouse;

    public ComputerController(ConsolePrinter printer, DataReader dataReader,
                              Cart cart, Warehouse warehouse)
    {
        this.printer = printer;
        this.dataReader = dataReader;
        this.cart = cart;
        this.warehouse = warehouse;
    }

    public void computerLoop(){
        ComputerMenu option;
        do{
            ComputerMenu.printComputerMenu(printer);
            option = ComputerMenu.getOption(dataReader.getInt(), printer);
            switch (option) {
                case GO_BACK -> {
                    System.out.println("go back");
                }
                case SELECT_PRESET -> {
                    selectPreset();
                }
                case CONFIGURE -> {
                    System.out.println("configure");
                }
            }
        }while (option != ComputerMenu.GO_BACK);
    }

    private void selectPreset(){
        List<Computer> computersInStock = warehouse.getComputersInStock();
        String option;
        do{
            for (int i = 0; i < computersInStock.size(); i++) {
                System.out.println(i+" - "+computersInStock.get(i));
            }
            System.out.println(5+" - Go back");
            option = dataReader.getString();
            switch (option){
                case "0"->{
                    cart.addProduct(computersInStock.get(0));
                }
                case "1"->{
                    cart.addProduct(computersInStock.get(1));
                }
                case "2"->{
                    cart.addProduct(computersInStock.get(2));
                }
                case "3"->{
                    cart.addProduct(computersInStock.get(3));
                }
                case "4"->{
                    cart.addProduct(computersInStock.get(4));
                }
                case "5"->{
                    option = "5";
                }
            }while (option.equals("5"));
        }


    }


}
