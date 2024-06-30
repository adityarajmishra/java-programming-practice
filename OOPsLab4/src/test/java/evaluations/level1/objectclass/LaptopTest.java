package evaluations.level1.objectclass;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class LaptopTest {

    @Test
    public void testToString() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.objectclass.Laptop");
        Constructor<?> constructor = clazz.getConstructor(int.class, int.class, String.class, String.class);
        Object instance = constructor.newInstance(1, 10, "ModelX", "BrandY");

        Method toStringMethod = clazz.getMethod("toString");
        assertEquals(clazz, toStringMethod.getDeclaringClass(), "toString method is not overridden in Laptop class");

        String toStringResult = (String) toStringMethod.invoke(instance);
        assertNotNull(toStringResult);
        assertFalse(toStringResult.isEmpty());
    }

    @Test
    public void testHashCode() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.objectclass.Laptop");
        Constructor<?> constructor = clazz.getConstructor(int.class, int.class, String.class, String.class);
        Object instance = constructor.newInstance(1, 1000, "ModelX", "BrandY");

        Method hashCodeMethod = clazz.getMethod("hashCode");
        assertEquals(clazz, hashCodeMethod.getDeclaringClass(), "hashCode method is not overridden in Laptop class");

        int hashCodeResult = (int) hashCodeMethod.invoke(instance);
        assertTrue(hashCodeResult != 0);
    }
}
