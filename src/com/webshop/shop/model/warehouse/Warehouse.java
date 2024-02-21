package com.webshop.shop.model.warehouse;

import com.webshop.shop.model.product.Computer;
import com.webshop.shop.model.product.Electronic;
import com.webshop.shop.model.product.Product;
import com.webshop.shop.model.product.Smartphone;
import com.webshop.shop.model.product.computerParts.Cpus;
import com.webshop.shop.model.product.computerParts.Gpus;
import com.webshop.shop.model.product.computerParts.Harddrives;
import com.webshop.shop.model.product.computerParts.RAM;
import com.webshop.shop.model.product.electronicTypes.ElectronicTypes;
import com.webshop.shop.model.product.phoneParts.Camera;
import com.webshop.shop.model.product.phoneParts.Color;
import com.webshop.shop.model.product.phoneParts.Model;
import com.webshop.shop.model.product.phoneParts.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Warehouse {

    private static final int nrOfItems = 5;
    private List<Computer> computersInStock;
    private List<Smartphone> smartphonesInStock;
    private List<Electronic> electronicsInStock;

    public List<Computer> getComputersInStock() {
        return computersInStock;
    }

    public List<Smartphone> getSmartphonesInStock() {
        return smartphonesInStock;
    }

    public List<Electronic> getElectronicsInStock() {
        return electronicsInStock;
    }

    private static Random random = new Random();

    public Warehouse(){
        this.computersInStock = supplyComputers();
        this.smartphonesInStock = supplySmartphones();
        this.electronicsInStock = supplyElectronics();
    }

    // values for computer creation
    private static Cpus[] cpus = Cpus.values();
    private static Gpus[] gpus = Gpus.values();
    private static RAM[] rams = RAM.values();
    private static Harddrives[] harddrives = Harddrives.values();

    // values for smartphone creation
    private static Camera[] camers = Camera.values();
    private static Color[] colors = Color.values();
    private static Model[] models = Model.values();
    private static Storage[] storages = Storage.values();

    private static List<Computer> supplyComputers(){
        List<Computer> computers = new ArrayList<>();
        for(int i = 0; i < nrOfItems; i++){
            Computer comp = new Computer(
                    "Set "+i,
                    random.nextInt(10),
                    cpus[random.nextInt(cpus.length)],
                    gpus[random.nextInt(gpus.length)],
                    rams[random.nextInt(rams.length)],
                    harddrives[random.nextInt(rams.length)]
            );
            computers.add(comp);
        }
        return computers;
    }

    private static List<Smartphone> supplySmartphones(){
        List<Smartphone> smartphones = new ArrayList<>();
        for(int i = 0; i < nrOfItems; i++){
            Smartphone smartphone = new Smartphone(
                    "Smartphone "+i,
                    random.nextInt(10),
                    camers[random.nextInt(camers.length)],
                    colors[random.nextInt(colors.length)],
                    models[random.nextInt(models.length)],
                    storages[random.nextInt(storages.length)]
            );
            smartphones.add(smartphone);
        }
        return smartphones;
    }

    private static List<Electronic> supplyElectronics(){
        List<Electronic> electronics = new ArrayList<>();
        for (ElectronicTypes value : ElectronicTypes.values()) {
            Electronic electronic = new Electronic(
                    value.getName(),
                    random.nextInt(10),
                    value
            );
            electronics.add(electronic);
        }
        return electronics;
    }


}
