package section3.level3.employees;

import section3.level3.Employee3;

public class Analyst3 extends Employee3 {

    private int analystTeamSecretAccess;
    public Analyst3(int salary, String name, int analystTeamSecretAccess) {
        super(salary, name);
        this.analystTeamSecretAccess = analystTeamSecretAccess;
    }

    public void analyse() {
        System.out.println("I am analysing");
    }

}
