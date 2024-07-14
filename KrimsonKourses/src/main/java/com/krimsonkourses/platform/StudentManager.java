package com.krimsonkourses.platform;

import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private final Map<Integer, Student> students;

    public StudentManager() {
        students = new HashMap<>();
    }

    public String addStudent(String name, int id) {
        if (id < 0) {
            return "STUDENT_ID_NOT_VALID";
        }
        if (students.containsKey(id)) {
            return "STUDENT_ID_ALREADY_EXIST";
        }

        students.put(id, new Student(name, id));
        return "SUCCESS";
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    public boolean studentExists(int id) {
        return students.containsKey(id);
    }

    public int getStudentCount() {
        return students.size();
    }
}