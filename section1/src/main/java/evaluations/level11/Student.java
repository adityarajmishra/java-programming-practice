package evaluations.level11;

public class Student {

    private int id;
    private String name;
    private int feesPerMonth = 14000;
    private boolean hostler = false;

    public Student(int id, String name, int feesPerMonth, boolean hostler) {
        this.id = id;
        this.name = name;
        this.feesPerMonth = feesPerMonth;
        this.hostler = hostler;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }



    public int getId() {
        return id;
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

    public int getFeesPerMonth() {
        return feesPerMonth;
    }

    public void setFeesPerMonth(int feesPerMonth) {
        this.feesPerMonth = feesPerMonth;
    }

    public boolean isHostler() {
        return hostler;
    }

    public void setHostler(boolean hostler) {
        this.hostler = hostler;
    }
}
