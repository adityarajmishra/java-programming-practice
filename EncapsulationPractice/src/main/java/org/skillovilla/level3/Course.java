package org.skillovilla.level3;

public class Course {
    private String courseCode;
    private String courseName;
    private String instructor;
    private int credits;

    public Course(String courseCode, String courseName, String instructor, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCourseDetails() {
        return "Course Code: " + courseCode + ", " + "Course Name: " + courseName + ", " + "Instructor: " + instructor + ", " + "Credits: " + credits;
    }
    public String updateInstructor(String newInstructor) {
        return this.instructor = newInstructor;
    }
}
