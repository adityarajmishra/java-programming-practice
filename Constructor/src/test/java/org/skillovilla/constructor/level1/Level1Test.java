package org.skillovilla.constructor.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Level1Test {
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
        Class<?> personClass = Class.forName("org.skillovilla.constructor.level1.Person");
        Constructor<?> constructor = personClass.getDeclaredConstructor();
        constructor.newInstance();

        // Restore the original System.out
        System.setOut(originalOut);

        // Check if the output matches the expected result
        String expectedOutput = "A person is created.";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }
}
