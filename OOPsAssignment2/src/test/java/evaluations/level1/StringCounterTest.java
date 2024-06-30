package evaluations.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StringCounterTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testCountOneString() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.StringCounter");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("count", String.class);
        method.invoke(instance, "one");

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }

    @Test
    public void testCountTwoStrings() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.StringCounter");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("count", String.class, String.class);
        method.invoke(instance, "one", "two");

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }

    @Test
    public void testCountThreeStrings() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.StringCounter");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("count", String.class, String.class, String.class);
        method.invoke(instance, "one", "two", "three");

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }
}
