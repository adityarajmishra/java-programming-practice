package org.skillovilla.constructor.level4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Level4Test {
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
        Class<?> bookClass = Class.forName("org.skillovilla.constructor.level4.Book");
        Constructor<?> constructor = bookClass.getDeclaredConstructor(String.class, String.class);
        constructor.newInstance("1984", "George Orwell");

        // Restore the original System.out
        System.setOut(originalOut);

        // Check if the output matches the expected result
        String expectedOutput = "Title: 1984, Author: George Orwell";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }
}
