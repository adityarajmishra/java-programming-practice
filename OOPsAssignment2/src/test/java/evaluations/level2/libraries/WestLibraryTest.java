package evaluations.level2.libraries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WestLibraryTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testDescribeWestLibrary() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level2.libraries.WestLibrary");
        Object instance = clazz.getDeclaredConstructor(int.class, String.class, int.class).newInstance(1, "West Library", 72);

        Method method = clazz.getMethod("describe");
        method.invoke(instance);

        String output = outputStream.toString().trim();
        assertNotNull(output);

        assertFalse(output.isEmpty());
    }
}
