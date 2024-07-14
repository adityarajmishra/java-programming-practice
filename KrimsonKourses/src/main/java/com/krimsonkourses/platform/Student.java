package com.krimsonkourses.platform;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {
    private final String name;
    private final int id;
    private final Set<Course> courses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean hasCourse(Course course) {
        return courses.contains(course);
    }

    public int getCourseCount() {
        return courses.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}