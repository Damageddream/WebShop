package com.webshop.shop.app.controllers;

import com.webshop.shop.app.controllers.options.ComputerMenu;
import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.product.Computer;
import com.webshop.shop.model.warehouse.Warehouse;

import java.util.InputMismatchException;
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
                    configure();
                }
                default -> System.out.println("No such option, try again");
            }
        }while (option != ComputerMenu.GO_BACK);
    }

    private void selectPreset(){
        List<Computer> computersInStock = warehouse.getComputersInStock();
        String option;
        do{
            for (int i = 0; i < computersInStock.size(); i++) {
                printer.printLine(i+" - "+computersInStock.get(i));
            }
            printer.printLine(5+" - Go back");
            option = dataReader.getString();
            switch (option) {
                case "0" -> {
                    addToCart(0, computersInStock);
                }
                case "1" -> {
                    addToCart(1, computersInStock);
                }
                case "2" -> {
                    addToCart(2, computersInStock);
                }
                case "3" -> {
                    addToCart(3, computersInStock);
                }
                case "4" -> {
                    addToCart(4, computersInStock);
                }
                case "5" -> {
                    option = "5";
                }
            }
        }while(!option.equals("5"));

    }

    private void addToCart(int num, List<Computer> computersInStock){
        cart.addProduct(computersInStock.get(num));
        System.out.println("Computer added to cart");
    }

    private void configure(){
        boolean working = true;
        while (working){
            try {
                Computer comp = dataReader.readAndCreateComputer();
                cart.addProduct(comp);
                System.out.println("computer added to cart");
                working = false;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", try again:");
            } catch (InputMismatchException e) {
                printer.printLine("No number input, try again:");
            }
        }
    }
}
