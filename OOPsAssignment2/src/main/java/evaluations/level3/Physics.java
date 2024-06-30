package evaluations.level3;

public class Physics {

    private String teacher;
    private int numberOfClasses;
    private int numberOfStudents;

    public Physics(String teacher, int numberOfClasses, int numberOfStudents) {
        this.teacher = teacher;
        this.numberOfClasses = numberOfClasses;
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String toString() {
        return "Physics, taught by: " + teacher +
                ", numberOfClasses: " + numberOfClasses +
                " and numberOfStudents: " + numberOfStudents;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

}
