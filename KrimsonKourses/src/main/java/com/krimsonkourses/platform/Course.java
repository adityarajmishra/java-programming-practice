package com.krimsonkourses.platform;

import java.util.Objects;

public class Course {
    private final String name;
    private final int sequence;

    public Course(String name, int sequence) {
        this.name = name;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public int getSequence() {
        return sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return sequence == course.sequence && Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sequence);
    }
}