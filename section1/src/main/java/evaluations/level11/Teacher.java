package evaluations.level11;

public class Teacher {
    private int id;
    private String name;
    private int salaryPerMonth = 100000;
    private boolean permanent = true;

    public int getId() {
        return id;
    }

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(int salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public Teacher(int id, String name, int salaryPerMonth, boolean permanent) {
        this.id = id;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.permanent = permanent;
    }
}
