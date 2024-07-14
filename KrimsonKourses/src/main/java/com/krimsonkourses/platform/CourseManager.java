package com.krimsonkourses.platform;

import java.util.HashMap;
import java.util.Map;

public class CourseManager {
    private final Map<Integer, Course> courses;

    public CourseManager() {
        courses = new HashMap<>();
    }

    public String addCourse(String name, int sequence) {
        if (sequence < 1) {
            return "COURSE_SEQUENCE_NOT_VALID";
        }
        if (courses.values().stream().anyMatch(c -> c.getName().equals(name))) {
            return "COURSE_NAME_ALREADY_EXIST";
        }
        if (courses.containsKey(sequence)) {
            return "COURSE_SEQUENCE_ALREADY_EXIST";
        }
        if (sequence > courses.size() + 1) {
            return "ADD_COURSE_IN_SEQUENCE";
        }

        courses.put(sequence, new Course(name, sequence));
        return "SUCCESS";
    }

    public Course getCourse(int sequence) {
        return courses.get(sequence);
    }

    public boolean courseExists(int sequence) {
        return courses.containsKey(sequence);
    }

    public int getCourseCount() {
        return courses.size();
    }
}