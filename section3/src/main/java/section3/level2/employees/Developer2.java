package section3.level2.employees;

import section3.level2.Employee2;

public class Developer2 extends Employee2 {

    public String developersCodePassword;
    public Developer2(int salary, String name, String developersCodePassword) {
        super(salary, name);
        this.developersCodePassword = developersCodePassword;
    }

    public void develop() {
        System.out.println("I am developing");
    }

}
