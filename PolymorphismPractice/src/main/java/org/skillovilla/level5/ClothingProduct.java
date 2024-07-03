package org.skillovilla.level5;

public class ClothingProduct extends AbstractProduct {
    private double price;
    private String size;

    public ClothingProduct(String productId, String productName, double price, String size) {
        super(productId, productName);
        this.price = price;
        this.size = size;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDetails() {
        return super.getDetails()+ ", Price: " + price + ", Size: " + size;
    }

}
