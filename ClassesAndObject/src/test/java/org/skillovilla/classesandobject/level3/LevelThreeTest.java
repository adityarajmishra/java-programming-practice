package org.skillovilla.classesandobject.level3;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class LevelThreeTest {
    @Test
    public void testStudentClass() throws Exception {
        Class<?> studentClass = Class.forName("org.skillovilla.classesandobject.level3.Student");
        Object student = studentClass.getDeclaredConstructor().newInstance();

        Field nameField = studentClass.getDeclaredField("name");
        Field ageField = studentClass.getDeclaredField("age");
        nameField.setAccessible(true);
        ageField.setAccessible(true);

        nameField.set(student, "John");
        ageField.set(student, 21);

        Method displayInfo = studentClass.getDeclaredMethod("displayInfo");
        displayInfo.invoke(student);

        assertEquals("John", nameField.get(student));
        assertEquals(21, ageField.get(student));
    }
}
