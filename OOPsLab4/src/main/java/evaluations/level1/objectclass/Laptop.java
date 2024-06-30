package evaluations.level1.objectclass;

import java.util.Objects;

public class Laptop {
    private int id;
    private int price;
    private String model;
    private String brand;

    public Laptop(int id, int price, String model, String brand) {
        this.id = id;
        this.price = price;
        this.model = model;
        this.brand = brand;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, price, model, brand);
    }
}
