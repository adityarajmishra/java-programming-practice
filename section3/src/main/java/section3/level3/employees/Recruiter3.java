package section3.level3.employees;


import section3.level3.Employee3;

public class Recruiter3 extends Employee3 {
    private String recruitingSecrets;

    public Recruiter3(int salary, String name, String recruitingSecrets) {
        super(salary, name);
        this.recruitingSecrets = recruitingSecrets;
    }

    public void recruit() {
        System.out.println("I am recruiting");
    }
}
