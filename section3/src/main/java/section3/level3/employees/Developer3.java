package section3.level3.employees;

import section3.level3.Employee3;

public class Developer3 extends Employee3 {

    private String developersCodePassword;
    public Developer3(int salary, String name, String developersCodePassword) {
        super(salary, name);
        this.developersCodePassword = developersCodePassword;
    }

    public void develop() {
        System.out.println("I am developing");
    }

}
