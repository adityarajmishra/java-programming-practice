package evaluations.level5.implementations;

import evaluations.level5.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class CatTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testCatIsSubclassOfAnimal() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level5.implementations.Cat");

        // Check if Cat is a subclass of Animal
        assertTrue(Animal.class.isAssignableFrom(clazz), "Cat should be a subclass of Animal");
    }

    @Test
    public void testMakeSound() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level5.implementations.Cat");
        Object instance = clazz.getDeclaredConstructor(String.class, String.class, int.class).newInstance("Siamese", "Whiskers", 1);

        Method method = clazz.getMethod("makeSound");
        method.invoke(instance);

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }

    @Test
    public void testToString() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level5.implementations.Cat");
        Object instance = clazz.getDeclaredConstructor(String.class, String.class, int.class).newInstance("Siamese", "Whiskers", 1);

        Method method = clazz.getMethod("toString");
        String result = (String) method.invoke(instance);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        // Check that the toString method is overridden
        String defaultToString = instance.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(instance));
        assertFalse(result.equals(defaultToString));
    }
}
