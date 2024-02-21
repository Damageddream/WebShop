package com.webshop.shop.model.client;

import com.webshop.shop.io.file.CsvFileManager;
import com.webshop.shop.model.CsvConvertible;

import java.time.ZoneId;

public class Client implements CsvConvertible {
    private String name;
    private String lastName;
    private String address;
    private String email;
    private ZoneId userTimeZone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client(String name, String lastName, String address, String email) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.userTimeZone = ZoneId.systemDefault();
    }

    public ZoneId getUserTimeZone() {
        return userTimeZone;
    }

    @Override
    public String toString() {
        return
                "name: " + name +" "+ lastName+'\'' +
                "address: '" + address + '\''
                +"email: "+email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toCsv() {
        return name+";"+
                lastName+";"+
                address+";"+
                email+";";
    }
}
