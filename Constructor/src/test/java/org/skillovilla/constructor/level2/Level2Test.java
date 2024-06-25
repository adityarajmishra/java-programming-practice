package org.skillovilla.constructor.level2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Level2Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testParameterizedConstructor() throws Exception {
        Class<?> carClass = Class.forName("org.skillovilla.constructor.level2.Car");
        Constructor<?> constructor = carClass.getDeclaredConstructor(String.class, String.class);
        constructor.newInstance("Toyota", "Corolla");

        // Restore the original System.out
        System.setOut(originalOut);

        // Check if the output matches the expected result
        String expectedOutput = "Car make: Toyota, model: Corolla";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }
}
