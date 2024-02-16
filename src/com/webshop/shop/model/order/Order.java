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

    @Override
    public String toCsv() {
        return null;
    }
}
