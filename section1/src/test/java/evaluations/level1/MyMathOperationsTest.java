package evaluations.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class MyMathOperationsTest {


    @Test
    public void testDivide() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.MyMathOperations");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method divideMethod = clazz.getMethod("divide", int.class, int.class);
        int result = (int) divideMethod.invoke(instance, 6, 2);

        assertEquals(3, result);
    }

    @Test
    public void testMultiply() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.MyMathOperations");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method multiplyMethod = clazz.getMethod("multiply", int.class, int.class);
        int result = (int) multiplyMethod.invoke(instance, 4, 5);

        assertEquals(20, result);
    }
}