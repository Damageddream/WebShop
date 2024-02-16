package com.webshop.shop.model.warehouse;

import com.webshop.shop.model.product.computerParts.Cpus;
import com.webshop.shop.model.product.computerParts.Gpus;
import com.webshop.shop.model.product.computerParts.Harddrives;
import com.webshop.shop.model.product.computerParts.RAM;

import java.util.Random;

public class Warehouse {

    private Random random = new Random();

    //shared values
    private int quantity = random.nextInt(10);

    // values for computer creation
    private Cpus[] cpus = Cpus.values();
    private Gpus[] gpus = Gpus.values();
    private RAM[] rams = RAM.values();
    private Harddrives[] harddrives = Harddrives.values();



}
