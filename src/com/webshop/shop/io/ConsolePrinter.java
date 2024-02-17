package com.webshop.shop.io;

import com.webshop.shop.model.product.Computer;
import com.webshop.shop.model.product.Electronic;
import com.webshop.shop.model.product.Smartphone;

import java.util.List;

public class ConsolePrinter {
    public void printComputers(List<Computer> computers){
        long count = computers.stream()
                .map(Computer::toString)
                .peek(this::printLine)
                .count();
        if(count == 0){
            printLine("No computers in stock");
        }
    }
    public void printSmartphones(List<Smartphone> smartphones){
        long count = smartphones.stream()
                .map(Smartphone::toString)
                .peek(this::printLine)
                .count();
        if(count == 0){
            printLine("No smartphones in stock");
        }
    }

    public void printElectronics(List<Electronic> electronics){
        long count = electronics.stream()
                .map(Electronic::toString)
                .peek(this::printLine)
                .count();
        if(count == 0){
            printLine("No electronics in stock");
        }
    }



    public void printLine(String text) {
        System.out.println(text);
    }

}
