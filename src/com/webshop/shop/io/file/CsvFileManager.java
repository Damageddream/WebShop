package com.webshop.shop.io.file;

import com.webshop.shop.model.cart.Cart;
import com.webshop.shop.model.order.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class CsvFileManager {






    private void exportToCsv(Order order, String fileName) {
        String shopData = Order.SHOP_DATA;
        String client = order.getClient().toString();
        double price = order.getPriceToPay();
        Cart cart = order.getCart();

        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (T element : collection) {
                bufferedWriter.write(element.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku " + fileName);
        }
    }

}
