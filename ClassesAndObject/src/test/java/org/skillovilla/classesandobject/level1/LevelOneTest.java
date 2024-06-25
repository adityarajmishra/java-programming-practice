package org.skillovilla.classesandobject.level1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class LevelOneTest {
    @Test
    public void testCarClass() throws Exception {
        // Use reflection to load the Car class
        Class<?> carClass = Class.forName("org.skillovilla.classesandobject.level1.Car");

        // Create an instance of the Car class
        Object car = carClass.getDeclaredConstructor().newInstance();

        // Access and set the fields
        Field modelField = carClass.getDeclaredField("model");
        Field yearField = carClass.getDeclaredField("year");
        modelField.setAccessible(true);
        yearField.setAccessible(true);
        modelField.set(car, "Toyota");
        yearField.set(car, 2020);

        // Access and invoke the displayInfo method
        Method displayInfo = carClass.getDeclaredMethod("displayInfo");
        displayInfo.setAccessible(true);

        // Capture the output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        displayInfo.invoke(car);

        // Check the output
        String expectedOutput = "Model: Toyota, Year: 2020";
        String actualOutput = outContent.toString().trim().replace("\r", "");
        assertEquals(expectedOutput, actualOutput);
    }
}
