package org.skillovilla.level5;

public class ElectronicProduct extends AbstractProduct {
    private double price;
    private int warrantyPeriod;

    public ElectronicProduct(String productId, String productName, double price, int warrantyPeriod) {
        super(productId, productName);
        this.price = price;
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Price: " + price + ", Warranty Period: " + warrantyPeriod + " months";
    }

}
