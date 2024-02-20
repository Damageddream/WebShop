package com.webshop.shop.app.controllers;

import com.webshop.shop.exception.DataExportException;
import com.webshop.shop.io.file.CsvFileManager;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.client.Client;
import com.webshop.shop.model.order.Order;


public class OrderProcessor implements Runnable {

    private Order order;

    private CsvFileManager csvFileManager = new CsvFileManager();

    public OrderProcessor(Client client, Cart cart) {
        this.order = new Order(client, cart);
    }

    private void process(Order order){
        try{
            csvFileManager.exportOrder(order);
        }catch(DataExportException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void run() {
        process(order);
        System.out.println("Order finished processing");
    }
}
