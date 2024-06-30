package evaluations.level2.libraries;

import evaluations.level2.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class NorthLibraryTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testNorthLibraryIsSubclassOfLibrary() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level2.libraries.NorthLibrary");

        // Check if NorthLibrary is a subclass of Library
        assertTrue(Library.class.isAssignableFrom(clazz), "NorthLibrary should be a subclass of Library");
    }

    @Test
    public void testDescribeNorthLibrary() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level2.libraries.NorthLibrary");
        Object instance = clazz.getDeclaredConstructor(int.class, String.class, int.class).newInstance(2, "North Library", 123);

        Method method = clazz.getMethod("describe");
        method.invoke(instance);

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }


}
