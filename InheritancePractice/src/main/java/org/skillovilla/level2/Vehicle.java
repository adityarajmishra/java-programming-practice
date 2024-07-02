package org.skillovilla.level2;

public class Vehicle {
    private String Brand;
    private String model;

    public Vehicle(String brand, String model) {
        Brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return model;
    }
}
