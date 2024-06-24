package section3.level1.employees;

import section3.level1.Employee;

public class Recruiter extends Employee {
    public int salary;
    public String name;
    public String recruitingSecrets;
    public Recruiter(int salary, String name, String recruitingSecrets) {
        this.salary = salary;
        this.name = name;
        this.recruitingSecrets = recruitingSecrets;
    }

    public void recruit() {
        System.out.println("I am recruiting");
    }
}
