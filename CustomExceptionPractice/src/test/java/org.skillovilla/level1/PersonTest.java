package org.skillovilla.level1;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testValidAge() throws Exception {
        // Test valid age
        Class<?> personClass = Class.forName("org.skillovilla.level1.Person");
        Constructor<?> personConstructor = personClass.getDeclaredConstructor(String.class, int.class);

        assertDoesNotThrow(() -> personConstructor.newInstance("Alice", 30));
    }

    @Test
    void testInvalidAgeNegative() throws Exception {
        // Test invalid age (negative)
        Class<?> personClass = Class.forName("org.skillovilla.level1.Person");
        Constructor<?> personConstructor = personClass.getDeclaredConstructor(String.class, int.class);

        assertThrows(Exception.class, () -> {
            try {
                personConstructor.newInstance("Bob", -1);
            } catch (Exception e) {
                if (e.getCause() != null && e.getCause().getClass().getName().equals("org.skillovilla.level1.InvalidAgeException")) {
                    throw (Exception) e.getCause();
                }
                throw e;
            }
        });
    }

    @Test
    void testInvalidAgeTooHigh() throws Exception {
        // Test invalid age (too high)
        Class<?> personClass = Class.forName("org.skillovilla.level1.Person");
        Constructor<?> personConstructor = personClass.getDeclaredConstructor(String.class, int.class);

        assertThrows(Exception.class, () -> {
            try {
                personConstructor.newInstance("Charlie", 200);
            } catch (Exception e) {
                if (e.getCause() != null && e.getCause().getClass().getName().equals("org.skillovilla.level1.InvalidAgeException")) {
                    throw (Exception) e.getCause();
                }
                throw e;
            }
        });
    }
}
