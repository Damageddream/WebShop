package com.webshop.shop.app.controllers;

import com.webshop.shop.app.controllers.options.ComputerMenu;
import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.exception.ProductUnvaliableException;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.product.Computer;
import com.webshop.shop.model.product.Product;
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
            option = ComputerMenu.getOption(dataReader, printer);
            switch (option) {
                case GO_BACK -> {
                    printer.printLine("go back");
                }
                case SELECT_PRESET -> {
                    try{
                        selectPreset();
                    }catch (InputMismatchException e){
                        printer.printLine("Invalid input try again");
                    }
                }
                case CONFIGURE -> {
                    configure();
                }
            }
        }while (option != ComputerMenu.GO_BACK);
    }

    private void selectPreset(){
        List<Computer> computersInStock = warehouse.getComputersInStock();
        String option;
        do{
            for (int i = 0; i < computersInStock.size(); i++) {
                Computer computer = computersInStock.get(i);
                printer.printLine(i+" - "+computer+" quantity: "+computer.getQuantity());
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
                default -> printer.printLine("No such option, choose again");

            }
        }while(!option.equals("5"));
    }
    private void addToCart(int num, List<Computer> computersInStock){
        try{
            cart.addProduct(computersInStock.get(num));
            printer.printLine("Computer added to cart");
        }catch (ProductUnvaliableException e){
            printer.printLine(e.getMessage());
        }
    }
    private void configure(){
        boolean working = true;
        while (working){
            try {
                Computer comp = dataReader.readAndCreateComputer();
                cart.addProduct(comp);
                printer.printLine("computer added to cart");
                working = false;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", try again:");
            } catch (InputMismatchException e) {
                printer.printLine("No number input, try again:");
            } catch (ProductUnvaliableException e){
                printer.printLine(e.getMessage());
            }
        }
    }
}
