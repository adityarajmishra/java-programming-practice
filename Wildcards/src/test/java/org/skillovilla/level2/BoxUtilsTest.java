package org.skillovilla.level2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BoxUtilsTest {

    @Test
    void testPrintBoxInfoMethodExists() {
        try {
            // Load the BoxUtils class
            Class<?> boxUtilsClass = Class.forName("org.skillovilla.level2.BoxUtils");

            // Check if the printBoxInfo method exists
            Method printBoxInfoMethod = boxUtilsClass.getDeclaredMethod("printBoxInfo", Box.class);
            assertNotNull(printBoxInfoMethod, "The printBoxInfo method should exist.");

        } catch (ClassNotFoundException e) {
            fail("BoxUtils class not found.");
        } catch (NoSuchMethodException e) {
            fail("printBoxInfo method not found in BoxUtils class.");
        }
    }

    @Test
    void testPrintBoxInfoFunctionality() {
        try {
            // Load the BoxUtils class
            Class<?> boxUtilsClass = Class.forName("org.skillovilla.level2.BoxUtils");

            // Retrieve the printBoxInfo method
            Method printBoxInfoMethod = boxUtilsClass.getMethod("printBoxInfo", Box.class);

            // Create Box instances
            Box<Integer> positiveBox = new Box<>(42);
            Box<Integer> negativeBox = new Box<>(-1);
            Box<Integer> zeroBox = new Box<>(0);

            // Capture the output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            // Invoke the printBoxInfo method with the positiveBox instance
            printBoxInfoMethod.invoke(null, positiveBox);
            String output = outContent.toString();
            assertTrue(output.contains("positive"), "The output should contain 'positive'.");

            // Reset the output stream
            outContent.reset();

            // Invoke the printBoxInfo method with the negativeBox instance
            printBoxInfoMethod.invoke(null, negativeBox);
            output = outContent.toString();
            assertTrue(output.contains("negative"), "The output should contain 'negative'.");

            // Reset the output stream
            outContent.reset();

            // Invoke the printBoxInfo method with the zeroBox instance
            printBoxInfoMethod.invoke(null, zeroBox);
            output = outContent.toString();
            assertTrue(output.contains("zero"), "The output should contain 'zero'.");

            // Restore the original System.out
            System.setOut(originalOut);

        } catch (Exception e) {
            fail("An error occurred while testing the printBoxInfo method: " + e.getMessage());
        }
    }
}
