package com.webshop.shop.model.order;

import com.webshop.shop.model.CsvConvertible;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.client.Client;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Order implements CsvConvertible {
    public static final String SHOP_DATA =
            """
            Name: Web Shop;
            Adress: Beverly Hill 90210;
            E-mail: webshop@gmail.com;
            """;
    private Client client;
    private Cart cart;
    private double priceToPay;

    private ZonedDateTime dateTime;

    public Order(Client client, Cart cart) {
        this.client = client;
        this.cart = cart;
        this.priceToPay = cart.getTotalPrice();
        dateTime =ZonedDateTime.now(client.getUserTimeZone());
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getPriceToPay() {
        return priceToPay;
    }

    public void setPriceToPay(double priceToPay) {
        this.priceToPay = priceToPay;
    }

    public void checkAndApplyDiscount(){
        double cartTotalPrice = cart.getTotalPrice();
        if(cartTotalPrice > 10000){
            cart.setTotalPrice(cartTotalPrice+(cartTotalPrice*0.15));
            System.out.println("We implemented discount 15% to your order!");
        }
    }

    @Override
    public String toCsv() {
        return SHOP_DATA+
                priceToPay+";"
                +dateTime+";";
    }

}
