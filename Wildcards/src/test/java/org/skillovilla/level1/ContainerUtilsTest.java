package org.skillovilla.level1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class ContainerUtilsTest {

    @Test
    void testMyContainerDataMethodExists() {
        try {
            // Load the ContainerUtils class
            Class<?> containerUtilsClass = Class.forName("org.skillovilla.level1.ContainerUtils");

            // Check if the myContainerData method exists
            Method myContainerDataMethod = containerUtilsClass.getDeclaredMethod("myContainerData", Container.class);
            assertNotNull(myContainerDataMethod, "The myContainerData method should exist.");

        } catch (ClassNotFoundException e) {
            fail("ContainerUtils class not found.");
        } catch (NoSuchMethodException e) {
            fail("myContainerData method not found in ContainerUtils class.");
        }
    }

    @Test
    void testMyContainerDataFunctionality() {
        try {
            // Load the ContainerUtils class
            Class<?> containerUtilsClass = Class.forName("org.skillovilla.level1.ContainerUtils");

            // Retrieve the myContainerData method
            Method myContainerDataMethod = containerUtilsClass.getMethod("myContainerData", Container.class);

            // Create Container instances
            Container<Integer> integerContainer = new Container<>(42);
            Container<String> stringContainer = new Container<>("Hello, World!");

            // Invoke the myContainerData method with the integer container
            myContainerDataMethod.invoke(null, integerContainer);

            // Invoke the myContainerData method with the string container
            myContainerDataMethod.invoke(null, stringContainer);

        } catch (Exception e) {
            fail("An error occurred while testing the myContainerData method: " + e.getMessage());
        }
    }
}
