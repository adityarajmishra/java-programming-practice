package evaluations.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculatorTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }



    @Test
    public void testAddFloat() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.Calculator");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("add", float.class, float.class);
        method.invoke(instance, 3.5f, 4.5f);

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }

    @Test
    public void testAddDouble() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.Calculator");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("add", double.class, double.class);
        method.invoke(instance, 3.5, 4.5);

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }

    @Test
    public void testAddLong() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.Calculator");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("add", long.class, long.class);
        method.invoke(instance, 3L, 4L);

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }
}
