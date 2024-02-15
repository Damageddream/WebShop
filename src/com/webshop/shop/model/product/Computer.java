package com.webshop.shop.model.product;

import java.util.Scanner;

public class Computer extends Product{
    private String cpu;
    private String gpu;
    private String RAM;
    private String harddrive;

    private Computer(int id, String name, double price, int quantity, String cpu, String gpu, String RAM, String harddrive) {
        super(id, name, price, quantity);
        this.cpu = cpu;
        this.gpu = gpu;
        this.RAM = RAM;
        this.harddrive = harddrive;
    }

    public String getCpu() {
        return cpu;
    }

    private void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    private void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getRAM() {
        return RAM;
    }

    private void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getHarddrive() {
        return harddrive;
    }

    private void setHarddrive(String harddrive) {
        this.harddrive = harddrive;
    }

    @Override
    void configure(Scanner sc) {

    }
}
