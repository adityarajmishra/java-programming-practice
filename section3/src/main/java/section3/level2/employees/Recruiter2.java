package section3.level2.employees;

import section3.level2.Employee2;

public class Recruiter2 extends Employee2 {

    public String recruitingSecrets;
    public Recruiter2(int salary, String name, String recruitingSecrets) {
        super(salary, name);
        this.recruitingSecrets = recruitingSecrets;
    }

    public void recruit() {
        System.out.println("I am recruiting");
    }
}
