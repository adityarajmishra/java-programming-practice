package evaluations.level2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExceptionHandlingApplicationTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(errorStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testHandleException() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level2.ExceptionHandlingApplication");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method handleExceptionMethod = clazz.getMethod("handleException");
        handleExceptionMethod.invoke(instance);

        String errorOutput = errorStream.toString().trim();
        assertNotNull(errorOutput);
    }

    @Test
    public void testGenerateStackTrace() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level2.ExceptionHandlingApplication");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method generateStackTraceMethod = clazz.getMethod("generateStackTrace");
        generateStackTraceMethod.invoke(instance);

        String errorOutput = errorStream.toString().trim();
        assertTrue(errorOutput.contains("ArrayIndexOutOfBoundsException"));
    }
}
