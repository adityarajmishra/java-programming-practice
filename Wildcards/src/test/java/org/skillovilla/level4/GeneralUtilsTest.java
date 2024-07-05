package org.skillovilla.level4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class GeneralUtilsTest {

    @Test
    void testMethodsExist() {
        try {
            Class<?> generalUtilsClass = Class.forName("org.skillovilla.level4.GeneralUtils");

            Method displayDataMethod = generalUtilsClass.getDeclaredMethod("displayData", GeneralContainer.class);
            assertNotNull(displayDataMethod, "The displayData method should exist.");

            Method checkNumberMethod = generalUtilsClass.getDeclaredMethod("checkNumber", NumberContainer.class);
            assertNotNull(checkNumberMethod, "The checkNumber method should exist.");

            Method updateContainerMethod = generalUtilsClass.getDeclaredMethod("updateContainer", ValueContainer.class, Integer.class);
            assertNotNull(updateContainerMethod, "The updateContainer method should exist.");

        } catch (ClassNotFoundException e) {
            fail("GeneralUtils class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found in GeneralUtils class.");
        }
    }

    @Test
    void testDisplayDataFunctionality() {
        try {
            Class<?> generalUtilsClass = Class.forName("org.skillovilla.level4.GeneralUtils");

            Method displayDataMethod = generalUtilsClass.getMethod("displayData", GeneralContainer.class);

            GeneralContainer<String> stringContainer = new GeneralContainer<>("Test Data");

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            displayDataMethod.invoke(null, stringContainer);

            String output = outContent.toString();
            assertTrue(output.contains("Test Data"), "The output should contain 'Test Data'.");

            System.setOut(originalOut);

        } catch (Exception e) {
            fail("An error occurred while testing the displayData method: " + e.getMessage());
        }
    }

    @Test
    void testCheckNumberFunctionality() {
        try {
            Class<?> generalUtilsClass = Class.forName("org.skillovilla.level4.GeneralUtils");

            Method checkNumberMethod = generalUtilsClass.getMethod("checkNumber", NumberContainer.class);

            NumberContainer<Integer> positiveNumberContainer = new NumberContainer<>(10);
            NumberContainer<Integer> negativeNumberContainer = new NumberContainer<>(-10);
            NumberContainer<Integer> zeroNumberContainer = new NumberContainer<>(0);

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            checkNumberMethod.invoke(null, positiveNumberContainer);
            String positiveOutput = outContent.toString();
            assertTrue(positiveOutput.contains("positive"), "The output should contain 'positive' for positive number.");

            outContent.reset();
            checkNumberMethod.invoke(null, negativeNumberContainer);
            String negativeOutput = outContent.toString();
            assertTrue(negativeOutput.contains("negative"), "The output should contain 'negative' for negative number.");

            outContent.reset();
            checkNumberMethod.invoke(null, zeroNumberContainer);
            String zeroOutput = outContent.toString();
            assertTrue(zeroOutput.contains("zero"), "The output should contain 'zero' for zero number.");

            System.setOut(originalOut);

        } catch (Exception e) {
            fail("An error occurred while testing the checkNumber method: " + e.getMessage());
        }
    }

    @Test
    void testUpdateContainerFunctionality() {
        try {
            Class<?> generalUtilsClass = Class.forName("org.skillovilla.level4.GeneralUtils");

            Method updateContainerMethod = generalUtilsClass.getMethod("updateContainer", ValueContainer.class, Integer.class);

            ValueContainer<Number> numberValueContainer = new ValueContainer<>(5.5);

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            updateContainerMethod.invoke(null, numberValueContainer, 42);

            String output = outContent.toString();
            assertTrue(output.contains("42"), "The output should contain '42'.");

            System.setOut(originalOut);

        } catch (Exception e) {
            fail("An error occurred while testing the updateContainer method: " + e.getMessage());
        }
    }
}
