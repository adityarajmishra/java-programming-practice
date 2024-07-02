package org.skillovilla.level1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    @Test
    public void testStudentGettersAndSetters() throws Exception {
        Class<?> studentClass = Class.forName("org.skillovilla.level1.Student");
        Object student = studentClass.getDeclaredConstructor(int.class, String.class, int.class, String.class)
                .newInstance(101, "Alice", 20, "A");

        // Test getters
        Method getStudentIdMethod = studentClass.getMethod("getStudentId");
        Method getNameMethod = studentClass.getMethod("getName");
        Method getAgeMethod = studentClass.getMethod("getAge");
        Method getGradeMethod = studentClass.getMethod("getGrade");

        assertEquals(101, getStudentIdMethod.invoke(student));
        assertEquals("Alice", getNameMethod.invoke(student));
        assertEquals(20, getAgeMethod.invoke(student));
        assertEquals("A", getGradeMethod.invoke(student));

        // Test setters
        Method setStudentIdMethod = studentClass.getMethod("setStudentId", int.class);
        Method setNameMethod = studentClass.getMethod("setName", String.class);
        Method setAgeMethod = studentClass.getMethod("setAge", int.class);
        Method setGradeMethod = studentClass.getMethod("setGrade", String.class);

        setStudentIdMethod.invoke(student, 102);
        setNameMethod.invoke(student, "Bob");
        setAgeMethod.invoke(student, 21);
        setGradeMethod.invoke(student, "B");

        assertEquals(102, getStudentIdMethod.invoke(student));
        assertEquals("Bob", getNameMethod.invoke(student));
        assertEquals(21, getAgeMethod.invoke(student));
        assertEquals("B", getGradeMethod.invoke(student));
    }

    @Test
    public void testUpdateGrade() throws Exception {
        Class<?> studentClass = Class.forName("org.skillovilla.level1.Student");
        Object student = studentClass.getDeclaredConstructor(int.class, String.class, int.class, String.class)
                .newInstance(101, "Alice", 20, "A");

        Method updateGradeMethod = studentClass.getMethod("updateGrade", String.class);
        Method getGradeMethod = studentClass.getMethod("getGrade");

        updateGradeMethod.invoke(student, "A+");
        assertEquals("A+", getGradeMethod.invoke(student));
    }

    @Test
    public void testGetStudentDetails() throws Exception {
        Class<?> studentClass = Class.forName("org.skillovilla.level1.Student");
        Object student = studentClass.getDeclaredConstructor(int.class, String.class, int.class, String.class)
                .newInstance(101, "Alice", 20, "A");

        Method getStudentDetailsMethod = studentClass.getMethod("getStudentDetails");
        String details = (String) getStudentDetailsMethod.invoke(student);
        assertEquals("Student ID: 101, Name: Alice, Age: 20, Grade: A", details);
    }
}
