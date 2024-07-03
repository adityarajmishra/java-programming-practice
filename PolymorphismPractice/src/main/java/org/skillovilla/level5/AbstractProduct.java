package org.skillovilla.level5;

public abstract class AbstractProduct implements Product {
    private String productId;
    private String productName;

    public AbstractProduct(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    @Override
    public String getDetails() {
        return "Product ID: " + productId + ", Product Name: " + productName;
    }
}
