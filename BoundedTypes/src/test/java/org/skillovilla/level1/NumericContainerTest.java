package org.skillovilla.level1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class NumericContainerTest {

    @Test
    void testClassIsGenericWithBound() {
        try {
            // Load the NumericContainer class
            Class<?> numericContainerClass = Class.forName("org.skillovilla.level1.NumericContainer");

            // Check if the class is parameterized with a type parameter
            TypeVariable<?>[] typeParameters = numericContainerClass.getTypeParameters();
            assertEquals(1, typeParameters.length, "NumericContainer class should have one generic type parameter.");

            // Check if the type parameter has an upper bound of Number
            TypeVariable<?> typeParameter = typeParameters[0];
            Type[] bounds = typeParameter.getBounds();
            assertEquals(1, bounds.length, "Type parameter should have one bound.");
            assertEquals(Number.class, bounds[0], "Type parameter should be bounded by Number.");

        } catch (ClassNotFoundException e) {
            fail("NumericContainer class not found.");
        }
    }

    @Test
    void testFieldTypeIsGenericWithBound() {
        try {
            // Load the NumericContainer class
            Class<?> numericContainerClass = Class.forName("org.skillovilla.level1.NumericContainer");

            // Check if NumericContainer class has a field number of a generic type
            Field numberField = numericContainerClass.getDeclaredField("number");
            Type fieldType = numberField.getGenericType();
            assertTrue(fieldType instanceof TypeVariable, "Field number should be of a generic type.");
            TypeVariable<?> typeVariable = (TypeVariable<?>) fieldType;
            Type[] bounds = typeVariable.getBounds();
            assertEquals(1, bounds.length, "Field number should have one bound.");
            assertEquals(Number.class, bounds[0], "Field number should be bounded by Number.");

        } catch (Exception e) {
            fail("An error occurred while checking the field type: " + e.getMessage());
        }
    }

    @Test
    void testGetMethodReturnTypeIsGenericWithBound() {
        try {
            // Load the NumericContainer class
            Class<?> numericContainerClass = Class.forName("org.skillovilla.level1.NumericContainer");

            // Check if getNumber method returns a generic type
            Method getNumberMethod = numericContainerClass.getMethod("getNumber");
            Type returnType = getNumberMethod.getGenericReturnType();
            assertTrue(returnType instanceof TypeVariable, "getNumber method should return a generic type.");
            TypeVariable<?> typeVariable = (TypeVariable<?>) returnType;
            Type[] bounds = typeVariable.getBounds();
            assertEquals(1, bounds.length, "getNumber method return type should have one bound.");
            assertEquals(Number.class, bounds[0], "getNumber method return type should be bounded by Number.");

        } catch (Exception e) {
            fail("An error occurred while checking the getNumber method return type: " + e.getMessage());
        }
    }

    @Test
    void testSetMethodParameterTypeIsGenericWithBound() {
        try {
            // Load the NumericContainer class
            Class<?> numericContainerClass = Class.forName("org.skillovilla.level1.NumericContainer");

            // Check if setNumber method accepts a generic type
            Method setNumberMethod = numericContainerClass.getMethod("setNumber", Number.class);
            Type[] parameterTypes = setNumberMethod.getGenericParameterTypes();
            assertEquals(1, parameterTypes.length, "setNumber method should have one parameter.");
            assertTrue(parameterTypes[0] instanceof TypeVariable, "setNumber method parameter should be of a generic type.");
            TypeVariable<?> typeVariable = (TypeVariable<?>) parameterTypes[0];
            Type[] bounds = typeVariable.getBounds();
            assertEquals(1, bounds.length, "setNumber method parameter type should have one bound.");
            assertEquals(Number.class, bounds[0], "setNumber method parameter type should be bounded by Number.");

        } catch (Exception e) {
            fail("An error occurred while checking the setNumber method parameter type: " + e.getMessage());
        }
    }
}
