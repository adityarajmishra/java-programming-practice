package org.skillovilla.level2;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddTwoIntegers() throws Exception {
        // Test addition of two integers
        Class<?> calculatorClass = Class.forName("org.skillovilla.level2.Calculator");
        Object calculator = calculatorClass.getDeclaredConstructor().newInstance();
        Method addMethod = calculatorClass.getMethod("add", int.class, int.class);
        int result = (int) addMethod.invoke(calculator, 2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testAddThreeIntegers() throws Exception {
        // Test addition of three integers
        Class<?> calculatorClass = Class.forName("org.skillovilla.level2.Calculator");
        Object calculator = calculatorClass.getDeclaredConstructor().newInstance();
        Method addMethod = calculatorClass.getMethod("add", int.class, int.class, int.class);
        int result = (int) addMethod.invoke(calculator, 1, 2, 3);
        assertEquals(6, result);
    }

    @Test
    public void testAddDoubles() throws Exception {
        // Test addition of two doubles
        Class<?> calculatorClass = Class.forName("org.skillovilla.level2.Calculator");
        Object calculator = calculatorClass.getDeclaredConstructor().newInstance();
        Method addMethod = calculatorClass.getMethod("add", double.class, double.class);
        double result = (double) addMethod.invoke(calculator, 2.5, 3.0);
        assertEquals(5.5, result, 0.01);
    }
}
