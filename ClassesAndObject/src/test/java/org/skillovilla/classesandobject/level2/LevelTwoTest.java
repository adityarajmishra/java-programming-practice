package org.skillovilla.classesandobject.level2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class LevelTwoTest {
    @Test
    public void testBookClass() throws Exception {
        // Use reflection to load the Book class
        Class<?> bookClass = Class.forName("org.skillovilla.classesandobject.level2.Book");

        // Create an instance of the Book class
        Object book = bookClass.getDeclaredConstructor().newInstance();

        // Access and set the fields
        Field titleField = bookClass.getDeclaredField("title");
        Field authorField = bookClass.getDeclaredField("author");
        titleField.setAccessible(true);
        authorField.setAccessible(true);
        titleField.set(book, "1984");
        authorField.set(book, "George Orwell");

        // Access and invoke the displayInfo method
        Method displayInfo = bookClass.getDeclaredMethod("displayInfo");
        displayInfo.setAccessible(true);

        // Capture the output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        displayInfo.invoke(book);

        // Check the output
        assertEquals("Title: 1984, Author: George Orwell", outContent.toString().trim());
    }
}
