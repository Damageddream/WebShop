package com.webshop.shop.io.file;

import com.webshop.shop.exception.DataExportException;
import com.webshop.shop.model.client.Client;
import com.webshop.shop.model.order.Order;
import com.webshop.shop.model.product.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileManager {
    private static int FV_ID_POOL = 1;
    private void exportToCsv(Order order, String fileName) {
        Client client = order.getClient();
        List<Product> products = order.getCart().getCartProducts();
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(client.toCsv());
                bufferedWriter.newLine();
                bufferedWriter.write(order.toCsv());
                bufferedWriter.newLine();
            for (Product product : products) {
                bufferedWriter.write(product.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Error in data saving " + fileName);
        }
    }

    private String createFileName(Order order){
        String fileName = order.getClient().getLastName()+"/"+FV_ID_POOL;
        FV_ID_POOL++;
        return fileName;
    }

    public void exportOrder(Order order){
        exportToCsv(order, createFileName(order));
    }

}
