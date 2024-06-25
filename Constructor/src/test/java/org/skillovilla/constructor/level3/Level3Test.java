package org.skillovilla.constructor.level3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Level3Test {
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
    public void testDefaultConstructor() throws Exception {
        Class<?> animalClass = Class.forName("org.skillovilla.constructor.level3.Animal");
        Constructor<?> constructor = animalClass.getDeclaredConstructor();
        constructor.newInstance();

        // Restore the original System.out
        System.setOut(originalOut);

        // Check if the output matches the expected result
        String expectedOutput = "An animal is created.";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }
}
