package org.skillovilla.level3;

public abstract class Employee {
    private String name;
    private int Id;

    public Employee(String name, int id) {
        this.name = name;
        Id = id;
    }
    public abstract double calculateSalary();
    public String getEmployeeDetails() {
        return "ID: " + Id + ", Name: " + name;
    }
}
