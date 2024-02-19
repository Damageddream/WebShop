package com.webshop.shop.app.controllers;

import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.client.Client;
import com.webshop.shop.model.order.Order;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderProcessor implements Runnable {

    private Order order;

    public OrderProcessor(Client client, Cart cart) {
        this.order = new Order(client, cart);
    }

    private void process(){

    }

    @Override
    public void run() {
        process();
    }
}
