package com.webshop.shop.app;

import com.webshop.shop.app.controllers.ShopController;
import com.webshop.shop.model.product.Computer;
import com.webshop.shop.model.product.computerParts.Cpus;
import com.webshop.shop.model.product.computerParts.Gpus;
import com.webshop.shop.model.product.computerParts.Harddrives;
import com.webshop.shop.model.product.computerParts.RAM;

public class ShopApp {
    private static final String APP_NAME = "Webshop v 1.0";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        ShopController shopControl = new ShopController();
        shopControl.mainLoop();
    }
}
