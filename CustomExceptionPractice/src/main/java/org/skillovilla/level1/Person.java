package org.skillovilla.level1;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
