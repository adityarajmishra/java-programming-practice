package org.skillovilla.level1;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private String grade;

    public Student(int studentId, String name, int age, String grade) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String updateGrade(String newGrade) {
        return this.grade = newGrade;
    }
    public String getStudentDetails() {
        return "Student ID: " +studentId +", "+ "Name: " +name+", "+ "Age: "+age+", "+ "Grade: " +grade;
    }

}
