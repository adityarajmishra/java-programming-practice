package org.skillovilla.level3;

public class ContractEmployee extends Employee {

    private final double hourlyRate;
    private final int hoursWorked;

    public ContractEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String getEmployeeDetails() {
        return super.getEmployeeDetails();
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

}
