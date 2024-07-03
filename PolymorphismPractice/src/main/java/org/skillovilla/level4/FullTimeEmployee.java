package org.skillovilla.level4;

public class FullTimeEmployee extends Employee {
    private final double salary;

    public FullTimeEmployee(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    @Override
    public double calculatePay() {
        return salary;
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }
}
