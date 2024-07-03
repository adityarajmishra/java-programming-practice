package org.skillovilla.level4;

public abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract double calculatePay();

    public String getDetails() {
        return "ID: " + id + ", Name: " + name;
    }
}
