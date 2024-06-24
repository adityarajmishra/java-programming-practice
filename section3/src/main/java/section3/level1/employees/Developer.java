package section3.level1.employees;

import section3.level1.Employee;

public class Developer extends Employee {
    public int salary;
    public String name;
    public String developersCodePassword;
    public Developer(int salary, String name, String developersCodePassword) {
        this.salary = salary;
        this.name = name;
        this.developersCodePassword = developersCodePassword;
    }

    public void develop() {
        System.out.println("I am developing");
    }
}
