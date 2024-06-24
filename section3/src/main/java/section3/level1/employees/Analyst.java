package section3.level1.employees;

import section3.level1.Employee;

public class Analyst extends Employee {
    public int salary;
    public String name;
    public int analystTeamSecretAccess;
    public Analyst(int salary, String name, int analystTeamSecretAccess) {
        this.salary = salary;
        this.name = name;
        this.analystTeamSecretAccess = analystTeamSecretAccess;
    }

    public void analyse() {
        System.out.println("I am analysing");
    }
}
