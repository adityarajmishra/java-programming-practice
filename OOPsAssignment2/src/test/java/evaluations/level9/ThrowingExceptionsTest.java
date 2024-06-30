package evaluations.level9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class ThrowingExceptionsTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(outputStream));
    }

    @Test
    public void testClassNotFoundException() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level9.ThrowingExceptions");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("classNotFoundException");
        try {
            method.invoke(instance);
            fail("Expected ClassNotFoundException to be thrown");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof ClassNotFoundException)) {
                fail("Expected ClassNotFoundException, but got " + cause);
            }
        }

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }

    @Test
    public void testFileNotFoundException() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level9.ThrowingExceptions");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("fileNotFoundException");
        try {
            method.invoke(instance);
            fail("Expected FileNotFoundException to be thrown");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof FileNotFoundException)) {
                fail("Expected FileNotFoundException, but got " + cause);
            }
        }

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }

    @Test
    public void testNullPointerExceptionExample() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level9.ThrowingExceptions");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("nullPointerExceptionExample");
        try {
            method.invoke(instance);
            fail("Expected NullPointerException to be thrown");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof NullPointerException)) {
                fail("Expected NullPointerException, but got " + cause);
            }
        }

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }

    @Test
    public void testHandleArithmeticAndNumberFormat() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level9.ThrowingExceptions");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("handleArithmeticAndNumberFormat");
        try {
            method.invoke(instance);
            fail("Expected ArithmeticException or NumberFormatException to be thrown");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof ArithmeticException || cause instanceof NumberFormatException)) {
                fail("Expected ArithmeticException or NumberFormatException, but got " + cause);
            }
        }

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }
}
