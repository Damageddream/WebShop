package com.webshop.shop.app.controllers;

import com.webshop.shop.exception.DataExportException;
import com.webshop.shop.exception.EmpytCartException;
import com.webshop.shop.io.file.CsvFileManager;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.client.Client;
import com.webshop.shop.model.order.Order;
/**
 * Represents a task responsible for processing a single order within the web shop.
 * An `OrderProcessor` validates the order, applies any applicable discounts,
 * handles the file export process, and provides status updates. It implements
 * the {@code Runnable} interface to be executed by a thread.
 *
 * @author Marcin
 * @version 1.0
 */
public class OrderProcessor implements Runnable {

    private Order order;

    private CsvFileManager csvFileManager = new CsvFileManager();
    /**
     * Constructs a new `OrderProcessor` to handle the given client's order.
     *
     * @param client The client associated with the order.
     * @param cart   The cart containing the order items.
     */
    public OrderProcessor(Client client, Cart cart) {
        this.order = new Order(client, cart);
    }

    /**
     * Processes the assigned order.  This involves checking for an empty cart,
     * applying discounts, exporting order data to a file, and handling
     * potential exceptions.
     *
     * @param order The order to be processed.
     */
    private void process(Order order){
        try{
            order.checkIfCartEmpty();
            order.checkAndApplyDiscount();
            csvFileManager.exportOrder(order);
        }catch(DataExportException | EmpytCartException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Overrides the `run` method of the {@code Runnable} interface.
     * This method is invoked when the `OrderProcessor` is executed by a thread,
     * initiating the order processing logic.
     */
    @Override
    public void run() {
        process(order);
        order.getCart().clear();
        System.out.println("Order finished processing");
    }
}
