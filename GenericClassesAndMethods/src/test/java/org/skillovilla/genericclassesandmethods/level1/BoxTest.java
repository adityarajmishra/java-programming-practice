package org.skillovilla.genericclassesandmethods.level1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BoxTest {

    @Test
    void testClassIsGeneric() {
        try {
            // Load the Box class
            Class<?> boxClass = Class.forName("org.skillovilla.genericclassesandmethods.level1.Box");

            // Check if the class is parameterized with a type parameter
            Type[] genericInterfaces = boxClass.getGenericInterfaces();
            boolean isGeneric = false;

            // Check if the Box class directly implements a parameterized type interface
            for (Type type : genericInterfaces) {
                if (type instanceof ParameterizedType) {
                    isGeneric = true;
                    break;
                }
            }

            // Check if the Box class itself is a parameterized type
            if (!isGeneric) {
                Type genericSuperclass = boxClass.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    isGeneric = true;
                }
            }

            // If neither interfaces nor superclass indicate parameterized type, check the class itself
            if (!isGeneric) {
                Type[] typeParameters = boxClass.getTypeParameters();
                isGeneric = typeParameters.length == 1;
            }

            assertTrue(isGeneric, "Box class should be parameterized with a type parameter.");
        } catch (ClassNotFoundException e) {
            fail("Box class not found.");
        }
    }

    @Test
    void testFieldTypeIsGeneric() {
        try {
            // Load the Box class
            Class<?> boxClass = Class.forName("org.skillovilla.genericclassesandmethods.level1.Box");

            // Check if Box class has a field item of a generic type
            Field itemField = boxClass.getDeclaredField("item");
            assertTrue(itemField.getGenericType() instanceof Type, "Field item should be of a generic type.");

        } catch (Exception e) {
            fail("An error occurred while checking the field type: " + e.getMessage());
        }
    }

    @Test
    void testGetMethodReturnTypeIsGeneric() {
        try {
            // Load the Box class
            Class<?> boxClass = Class.forName("org.skillovilla.genericclassesandmethods.level1.Box");

            // Check if getItem method returns a generic type
            Method getItemMethod = boxClass.getMethod("getItem");
            assertTrue(getItemMethod.getGenericReturnType() instanceof Type, "getItem method should return a generic type.");

        } catch (Exception e) {
            fail("An error occurred while checking the getItem method return type: " + e.getMessage());
        }
    }

    @Test
    void testSetMethodParameterTypeIsGeneric() {
        try {
            // Load the Box class
            Class<?> boxClass = Class.forName("org.skillovilla.genericclassesandmethods.level1.Box");

            // Check if setItem method accepts a generic type
            Method setItemMethod = boxClass.getMethod("setItem", Object.class);
            assertTrue(setItemMethod.getGenericParameterTypes()[0] instanceof Type, "setItem method should accept a generic type.");

        } catch (Exception e) {
            fail("An error occurred while checking the setItem method parameter type: " + e.getMessage());
        }
    }
}
