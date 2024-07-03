package org.skillovilla.level4;

public class PartTimeEmployee extends Employee{
    private final double hourlyRate;
    private final double hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyRate, double hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }
}
