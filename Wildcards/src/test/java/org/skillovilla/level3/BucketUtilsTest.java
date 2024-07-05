package org.skillovilla.level3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BucketUtilsTest {

    @Test
    void testSetBucketDataMethodExists() {
        try {
            // Load the BucketUtils class
            Class<?> bucketUtilsClass = Class.forName("org.skillovilla.level3.BucketUtils");

            // Check if the setBucketData method exists
            Method setBucketDataMethod = bucketUtilsClass.getDeclaredMethod("setBucketData", Bucket.class, Integer.class);
            assertNotNull(setBucketDataMethod, "The setBucketData method should exist.");

        } catch (ClassNotFoundException e) {
            fail("BucketUtils class not found.");
        } catch (NoSuchMethodException e) {
            fail("setBucketData method not found in BucketUtils class.");
        }
    }

    @Test
    void testSetBucketDataFunctionality() {
        try {
            // Load the BucketUtils class
            Class<?> bucketUtilsClass = Class.forName("org.skillovilla.level3.BucketUtils");

            // Retrieve the setBucketData method
            Method setBucketDataMethod = bucketUtilsClass.getMethod("setBucketData", Bucket.class, Integer.class);

            // Create a Bucket instance
            Bucket<Number> numberBucket = new Bucket<>();

            // Capture the output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            // Invoke the setBucketData method
            setBucketDataMethod.invoke(null, numberBucket, 100);

            // Verify the output
            String output = outContent.toString();
            assertTrue(output.contains("Bucket data"), "The output should contain 'Bucket data'.");
            assertTrue(output.contains("100"), "The output should contain '100'.");

            // Restore the original System.out
            System.setOut(originalOut);

        } catch (Exception e) {
            fail("An error occurred while testing the setBucketData method: " + e.getMessage());
        }
    }
}
