package com.webshop.shop.model.order;

import com.webshop.shop.model.CsvConvertible;
import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.client.Client;

public class Order implements CsvConvertible {
    public static final String SHOP_DATA =
            """
            Name: Web Shop
            Adress: Beverly Hill 90210
            E-mail: webshop@gmail.com
            """;
    private Client client;
    private Cart cart;
    private double priceToPay;

    public Order(Client client, Cart cart, double priceToPay) {
        this.client = client;
        this.cart = cart;
        this.priceToPay = priceToPay;
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

    @Override
    public String toCsv() {
        return null;
    }
}
