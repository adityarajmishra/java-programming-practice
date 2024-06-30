package evaluations.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddFloat() throws Exception {
        Method method = Calculator.class.getMethod("add", float.class, float.class);
        float result = (float) method.invoke(calculator, 3.0f, 4.0f);
        assertEquals(7.0f, result);
    }

    @Test
    public void testSubtractFloat() throws Exception {
        Method method = Calculator.class.getMethod("subtract", float.class, float.class);
        float result = (float) method.invoke(calculator, 5.5f, 2.0f);
        assertEquals(3.5f, result);
    }

    @Test
    public void testMultiplyFloat() throws Exception {
        Method method = Calculator.class.getMethod("multiply", float.class, float.class);
        float result = (float) method.invoke(calculator, 2.0f, 3.0f);
        assertEquals(6.0f, result);
    }
}
