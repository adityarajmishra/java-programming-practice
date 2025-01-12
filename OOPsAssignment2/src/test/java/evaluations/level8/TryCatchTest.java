package evaluations.level8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TryCatchTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }



    @Test
    public void testPracticeOnYourOwn() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level8.TryCatch");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("practiceOnYourOwn");
        method.invoke(instance);

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }
}
