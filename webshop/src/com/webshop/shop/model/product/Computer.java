package com.webshop.shop.model.product;

import com.webshop.shop.model.product.computerParts.Cpus;
import com.webshop.shop.model.product.computerParts.Gpus;
import com.webshop.shop.model.product.computerParts.Harddrives;
import com.webshop.shop.model.product.computerParts.RAM;

import java.util.Objects;
import java.util.Scanner;

public class Computer extends Product{
    private static final int MONTAGE_PRICE = 500;
    private Cpus cpu;
    private Gpus gpu;
    private RAM ram;
    private Harddrives harddrive;

    public Computer(String name, int quantity, Cpus cpu, Gpus gpu, RAM ram, Harddrives harddrive) {
        super(name, quantity);
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.harddrive = harddrive;
        this.setPrice(calcluatePrice());
    }

    public Computer(String name, int quantity, int nrInCart, Cpus cpu, Gpus gpu, RAM ram, Harddrives harddrive) {
        super(name, quantity, nrInCart);
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.harddrive = harddrive;
        this.setPrice(calcluatePrice());
    }

    public Cpus getCpu() {
        return cpu;
    }

    public void setCpu(Cpus cpu) {
        this.cpu = cpu;
    }

    public Gpus getGpu() {
        return gpu;
    }

    public void setGpu(Gpus gpu) {
        this.gpu = gpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Harddrives getHarddrive() {
        return harddrive;
    }

    public void setHarddrive(Harddrives harddrive) {
        this.harddrive = harddrive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Computer computer = (Computer) o;
        return cpu == computer.cpu && gpu == computer.gpu && ram == computer.ram && harddrive == computer.harddrive;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpu, gpu, ram, harddrive);
    }

    @Override
    double calcluatePrice() {
        return cpu.getPrice()+gpu.getPrice()+ram.getPrice()+ harddrive.getPrice()+MONTAGE_PRICE;
    }

    @Override
    public String toString() {
        return super.toString() +"\n"
                +"Details: "+"cpu: "+cpu.getName()
                +" gpu: "+gpu.getName()+" RAM: "+ram.getName()
                +" harddrive: "+harddrive.getName();
    }

    @Override
    public String toCsv() {
        return cpu.getName()+";"+
                gpu.getName()+";"+
                ram.getName()+";"+
            harddrive.getName()+";"+
                getName()+";"+
                getPrice()+";"+
                getNrInCart();
    }
}
