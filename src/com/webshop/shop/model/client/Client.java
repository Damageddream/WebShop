package com.webshop.shop.model.client;
public class Client {
    private String name;
    private String lastName;
    private String address;
    private String email;

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
}
