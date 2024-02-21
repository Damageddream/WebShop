package com.webshop.shop.app.controllers;

import com.webshop.shop.app.controllers.options.MainMenu;
import com.webshop.shop.io.ConsolePrinter;
import com.webshop.shop.io.DataReader;
import com.webshop.shop.io.OrderTimeTracker;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.warehouse.Warehouse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * The central controller class responsible for the main operation of the web shop
 * application. It manages the primary menu loop, initializes core components
 * (cart, warehouse), delegates actions to specialized controllers, and handles
 * application shutdown logic.
 *
 * @author Marcin
 * @version 1.0
 */
public class ShopController {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private ExecutorService executor = Executors.newFixedThreadPool(4);
    private OrderTimeTracker orderTimeTracker = new OrderTimeTracker();

    private Cart cart;
    private Warehouse warehouse;

    public ShopController(){
        cart = new Cart();
        warehouse = new Warehouse();
    }
    /**
     * Initiates the main loop of the web shop application. It displays the
     * main menu, processes user input, and delegates actions to the appropriate
     * sub-controllers.
     */
    public void mainLoop(){
        orderTimeTracker.trackingStart();
        MainMenu option;
        do{
            MainMenu.printMainMenu(printer);
            option = MainMenu.getOption(dataReader, printer);
            switch (option) {
                case EXIT -> {
                    printer.printLine("Thank you for shopping, come again !"+" \uD83D\uDE01");
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
        CartController cartController = new CartController(printer, dataReader, cart, executor);
        cartController.cartLoop();
    }
    /**
     * Handles the shutdown procedure of the application. This includes gracefully
     * terminating the thread executor and releasing associated resources.
     */
    private void shutdown(){
        executor.shutdown();
        try{
            if(!executor.awaitTermination(5, TimeUnit.SECONDS)){
                executor.shutdown();
            }
        }catch(InterruptedException e){
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
    private void calculateOrderTime(){
        orderTimeTracker.trackingEnd();
        orderTimeTracker.getOrderDuration();
    }
    /**
     * Performs any final calculations related to the order duration and
     * initiates the shutdown process.
     */
    public void close(){
        calculateOrderTime();
        shutdown();
        dataReader.close();
    }

}
