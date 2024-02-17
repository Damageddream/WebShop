package com.webshop.shop.model.product;

import com.webshop.shop.model.product.phoneParts.Camera;
import com.webshop.shop.model.product.phoneParts.Color;
import com.webshop.shop.model.product.phoneParts.Model;
import com.webshop.shop.model.product.phoneParts.Storage;

public class Smartphone extends Product{

    private Camera camera;
    private Color color;
    private Model model;
    private Storage storage;


    public Smartphone(String name, int quantity, Camera camera, Color color, Model model, Storage storage) {
        super(name, quantity);
        this.camera = camera;
        this.color = color;
        this.model = model;
        this.storage = storage;
        this.setPrice(calcluatePrice());
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    double calcluatePrice() {
        return camera.getPrice()+color.getPrice()+ model.getPrice()+ storage.getPrice();
    }

    @Override
    public String toString() {
        return super.toString() +"\n"
                +"Details: "+"model: "+model.getName()
                +" color: "+color.getName()+" camera: "+camera.getName()
                +" storage: "+storage.getName();
    }
}
