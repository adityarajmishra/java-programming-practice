package evaluations.level3.implementations;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvisibleCarTest {

    @Test
    public void testTypeMethod() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level3.implementations.InvisibleCar");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method typeMethod = clazz.getMethod("type");
        String type = (String) typeMethod.invoke(instance);
        assertTrue(type.contains("Invisible"));
    }

    @Test
    public void testNumberOfEnginesMethod() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level3.implementations.InvisibleCar");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method numberOfEnginesMethod = clazz.getMethod("numberOfEngines");
        int numberOfEngines = (int) numberOfEnginesMethod.invoke(instance);
        assertEquals(1, numberOfEngines);
    }

    @Test
    public void testMaterialMethod() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level3.implementations.InvisibleCar");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method materialMethod = clazz.getMethod("material");
        String material = (String) materialMethod.invoke(instance);
        assertTrue(material.contains("Kryptonian"));
    }
}
