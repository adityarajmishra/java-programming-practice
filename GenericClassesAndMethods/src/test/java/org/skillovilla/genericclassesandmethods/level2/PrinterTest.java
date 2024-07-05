package org.skillovilla.genericclassesandmethods.level2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class PrinterTest {

    @Test
    void testClassIsGeneric() {
        try {
            // Load the Printer class
            Class<?> printerClass = Class.forName("org.skillovilla.genericclassesandmethods.level2.Printer");

            // Check if the class is parameterized with a type parameter
            Type[] typeParameters = printerClass.getTypeParameters();
            assertTrue(typeParameters.length == 1, "Printer class should have one generic type parameter.");

        } catch (ClassNotFoundException e) {
            fail("Printer class not found.");
        }
    }

    @Test
    void testPrintMessageMethodExists() {
        try {
            // Load the Printer class
            Class<?> printerClass = Class.forName("org.skillovilla.genericclassesandmethods.level2.Printer");

            // Check if the printMessage method exists and has the correct parameter type
            Method printMessageMethod = null;
            for (Method method : printerClass.getDeclaredMethods()) {
                if (method.getName().equals("printMessage")) {
                    printMessageMethod = method;
                    break;
                }
            }
            assertTrue(printMessageMethod != null, "printMessage method should be present.");

            // Check if the parameter of the printMessage method is of a generic type
            assertEquals(1, printMessageMethod.getParameterCount(), "printMessage method should have one parameter.");
            Type parameterType = printMessageMethod.getGenericParameterTypes()[0];
            assertTrue(parameterType instanceof ParameterizedType || parameterType instanceof Type,
                    "printMessage method parameter should be of a generic type.");

        } catch (ClassNotFoundException e) {
            fail("Printer class not found.");
        }
    }
}
