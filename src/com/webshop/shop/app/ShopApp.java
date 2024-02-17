package com.webshop.shop.app;

import com.webshop.shop.model.product.Computer;
import com.webshop.shop.model.product.computerParts.Cpus;
import com.webshop.shop.model.product.computerParts.Gpus;
import com.webshop.shop.model.product.computerParts.Harddrives;
import com.webshop.shop.model.product.computerParts.RAM;

public class ShopApp {
    private static final String APP_NAME = "Webshop v 1.0";

    public static void main(String[] args) {
        Computer computer = new Computer("comp",1, Cpus.I5, Gpus.GEFORCE_3080, RAM.TEAMGROUP, Harddrives.FIRECUDE);
        System.out.println(computer);
    }
}
