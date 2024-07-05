package org.skillovilla.level2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberUtilsTest {

    @Test
    void testMethodIsGenericWithBound() {
        try {
            // Load the NumberUtils class
            Class<?> numberUtilsClass = Class.forName("org.skillovilla.level2.NumberUtils");

            // Check if the printNumber method is generic and has the correct bounds
            Method printNumberMethod = numberUtilsClass.getMethod("printNumber", Number.class);
            Type[] parameterTypes = printNumberMethod.getGenericParameterTypes();
            assertEquals(1, parameterTypes.length, "printNumber method should have one parameter.");
            assertTrue(parameterTypes[0] instanceof TypeVariable, "printNumber method parameter should be of a generic type.");

            // Check the bounds of the generic type parameter
            TypeVariable<?> typeVariable = (TypeVariable<?>) parameterTypes[0];
            Type[] bounds = typeVariable.getBounds();
            assertEquals(1, bounds.length, "printNumber method parameter type should have one bound.");
            assertEquals(Number.class, bounds[0], "printNumber method parameter type should be bounded by Number.");

        } catch (ClassNotFoundException e) {
            fail("NumberUtils class not found.");
        } catch (NoSuchMethodException e) {
            fail("printNumber method not found.");
        } catch (Exception e) {
            fail("An error occurred while checking the printNumber method: " + e.getMessage());
        }
    }

    @Test
    void testPrintNumberFunctionality() {
        try {
            // Load the NumberUtils class
            Class<?> numberUtilsClass = Class.forName("org.skillovilla.level2.NumberUtils");

            // Retrieve the printNumber method
            Method printNumberMethod = numberUtilsClass.getMethod("printNumber", Number.class);

            // Redirect System.out to capture the output
            java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outContent));

            // Invoke the printNumber method with different numeric types
            printNumberMethod.invoke(null, 42);
            assertTrue(outContent.toString().contains("42"), "The method should print 'Number: 42'");

            outContent.reset();
            printNumberMethod.invoke(null, 3.14);
            assertTrue(outContent.toString().contains("3.14"), "The method should print 'Number: 3.14'");

            outContent.reset();
            printNumberMethod.invoke(null, 2.71828);
            assertTrue(outContent.toString().contains("2.71828"), "The method should print 'Number: 2.71828'");

            // Test with invalid type
            assertThrows(IllegalArgumentException.class, () -> {
                printNumberMethod.invoke(null, "Not a number");
            }, "The method should throw an IllegalArgumentException when called with a non-Number type.");

            // Reset System.out
            System.setOut(System.out);

        } catch (Exception e) {
            fail("An error occurred while testing the printNumber method functionality: " + e.getMessage());
        }
    }
}
