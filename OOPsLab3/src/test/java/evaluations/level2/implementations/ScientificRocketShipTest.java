package evaluations.level2.implementations;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class ScientificRocketShipTest {

    @Test
    public void testFuelCapacity() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level2.implementations.ScientificRocketShip");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method fuelCapacityMethod = clazz.getMethod("fuelCapacity");
        int fuelCapacity = (int) fuelCapacityMethod.invoke(instance);
        assertEquals(2000, fuelCapacity);
    }

    @Test
    public void testPayload() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level2.implementations.ScientificRocketShip");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method payloadMethod = clazz.getMethod("payload");
        int payload = (int) payloadMethod.invoke(instance);
        assertEquals(1500, payload);
    }

    @Test
    public void testTypesOfPayloads() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level2.implementations.ScientificRocketShip");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method typesOfPayloadsMethod = clazz.getMethod("typesOfPayloads");
        typesOfPayloadsMethod.invoke(instance);

        String output = captureOutput(() -> {
            try {
                typesOfPayloadsMethod.invoke(instance);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
        assertNotNull(output);
        assertFalse(output.isEmpty());
    }

    private String captureOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        runnable.run();
        System.setOut(originalOut);
        return outputStream.toString();
    }
}
