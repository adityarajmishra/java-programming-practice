package evaluations.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class PhysicsTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testAllArgsConstructor() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level3.Physics");
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class, int.class);
        Object instance = constructor.newInstance("Dr. Smith", 5, 100);

        assertNotNull(instance);
    }

    @Test
    public void testGettersAndSetters() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level3.Physics");
        Object instance = clazz.getDeclaredConstructor(String.class, int.class, int.class).newInstance("Dr. Smith", 5, 100);

        // Test getter methods
        Method getTeacher = clazz.getMethod("getTeacher");
        Method getNumberOfClasses = clazz.getMethod("getNumberOfClasses");
        Method getNumberOfStudents = clazz.getMethod("getNumberOfStudents");

        assertEquals("Dr. Smith", getTeacher.invoke(instance));
        assertEquals(5, getNumberOfClasses.invoke(instance));
        assertEquals(100, getNumberOfStudents.invoke(instance));

        // Test setter methods
        Method setTeacher = clazz.getMethod("setTeacher", String.class);
        Method setNumberOfClasses = clazz.getMethod("setNumberOfClasses", int.class);
        Method setNumberOfStudents = clazz.getMethod("setNumberOfStudents", int.class);

        setTeacher.invoke(instance, "Prof. Johnson");
        setNumberOfClasses.invoke(instance, 10);
        setNumberOfStudents.invoke(instance, 200);

        assertEquals("Prof. Johnson", getTeacher.invoke(instance));
        assertEquals(10, getNumberOfClasses.invoke(instance));
        assertEquals(200, getNumberOfStudents.invoke(instance));
    }

    @Test
    public void testToString() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level3.Physics");
        Object instance = clazz.getDeclaredConstructor(String.class, int.class, int.class).newInstance("Dr. Smith", 5, 100);

        Method method = clazz.getMethod("toString");
        String result = (String) method.invoke(instance);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        // Check that the toString method is overridden
        String defaultToString = instance.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(instance));
        assertNotEquals(defaultToString, result);
    }
}
