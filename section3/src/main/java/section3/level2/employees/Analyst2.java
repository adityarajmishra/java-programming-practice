package section3.level2.employees;

import section3.level2.Employee2;

public class Analyst2 extends Employee2 {

    public int analystTeamSecretAccess;
    public Analyst2(int salary, String name, int analystTeamSecretAccess) {
        super(salary, name);
        this.analystTeamSecretAccess = analystTeamSecretAccess;
    }

    public void analyse() {
        System.out.println("I am analysing");
    }

}
