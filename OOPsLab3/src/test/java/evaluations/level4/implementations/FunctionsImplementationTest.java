package evaluations.level4.implementations;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionsImplementationTest {

    @Test
    public void testCubeMethod() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level4.implementations.FunctionsImplementation");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method cubeMethod = clazz.getMethod("cube");
        Object functionInstance = cubeMethod.invoke(instance);

        Method hashMethod = functionInstance.getClass().getMethod("hash", int.class);
        int result = (int) hashMethod.invoke(functionInstance, 3);
        assertEquals(27, result);
    }

    @Test
    public void testDecrementMethod() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level4.implementations.FunctionsImplementation");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method decrementMethod = clazz.getMethod("decrement");
        Object functionInstance = decrementMethod.invoke(instance);

        Method hashMethod = functionInstance.getClass().getMethod("hash", int.class);
        int result = (int) hashMethod.invoke(functionInstance, 3);
        assertEquals(2, result);
    }
}
