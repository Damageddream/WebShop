package com.webshop.shop.io;

import com.webshop.shop.exception.NoSuchOptionException;
import com.webshop.shop.model.client.Client;
import com.webshop.shop.model.product.Computer;
import com.webshop.shop.model.product.Electronic;
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

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);

    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer){
            this.printer = printer;
    }

    public String getString(){
        return sc.nextLine();
    }
    public void close(){
        sc.close();
    }

    public int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    public Computer readAndCreateComputer(int numInCart) throws NoSuchOptionException {
        printer.printLine("CPU: ");
        Cpus.printCpus();
        Cpus cpu = Cpus.createFromInt(getInt());
        printer.printLine("GPU: ");
        Gpus.printGpus();
        Gpus gpu = Gpus.createFromInt(getInt());
        printer.printLine("Harddrive: ");
        Harddrives.printHarddrives();
        Harddrives hardrive = Harddrives.createFromInt(getInt());
        printer.printLine("RAM: ");
        RAM.printRAM();
        RAM ram = RAM.createFromInt(getInt());
        return new Computer("Personolized PC", 1,numInCart, cpu, gpu, ram, hardrive);
    };

    public Smartphone readAndCreateSmartphone(int numInCart) throws NoSuchOptionException{
        printer.printLine("Model: ");
        Model.printModels();
        Model model = Model.createFromInt(getInt());
        printer.printLine("Camera: ");
        Camera.printCameras();
        Camera camera = Camera.createFromInt(getInt());
        printer.printLine("Color: ");
        Color.printColors();
        Color color = Color.createFromInt(getInt());
        printer.printLine("Storage: ");
        Storage.printStorages();
        Storage storage = Storage.createFromInt(getInt());
        return new Smartphone("Personalized smartphone", 1,numInCart, camera, color, model, storage);
    }
    public Electronic readAndCreateElectronic(int numInCart) throws NoSuchOptionException{
        printer.printLine("Choose electronic: ");
        ElectronicTypes.printElectronicTypes();
        ElectronicTypes electronic = ElectronicTypes.createFromInt(getInt());
        return new Electronic("Personalaized electronic", 1,numInCart, electronic);
    }
    public Client readAndCreateUser(){
        printer.printLine("Name: ");
        String name = sc.nextLine();
        printer.printLine("Last name: ");
        String lastName = sc.nextLine();
        printer.printLine("Address: ");
        String address = sc.nextLine();
        printer.printLine("E-mail: ");
        String email = sc.nextLine();
        return new Client(name, lastName, address, email);
    }



}
