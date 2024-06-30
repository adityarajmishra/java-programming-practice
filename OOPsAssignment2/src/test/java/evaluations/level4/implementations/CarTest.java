package evaluations.level4.implementations;

import evaluations.level4.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testCarIsSubclassOfVehicle() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level4.implementations.Car");

        // Check if Car is a subclass of Vehicle
        assertTrue(Vehicle.class.isAssignableFrom(clazz), "Car should be a subclass of Vehicle");
    }

    @Test
    public void testSpeedInitialization() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level4.implementations.Car");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method getSpeedMethod = clazz.getMethod("getSpeed");
        int speed = (int) getSpeedMethod.invoke(instance);
        assertEquals(0, speed);
    }

    @Test
    public void testStart() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level4.implementations.Car");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("start");
        method.invoke(instance);

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());

        // Verify the speed is set to 1
        Method getSpeedMethod = clazz.getMethod("getSpeed");
        int speed = (int) getSpeedMethod.invoke(instance);
        assertEquals(1, speed);
    }

    @Test
    public void testAccelerate() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level4.implementations.Car");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method startMethod = clazz.getMethod("start");
        startMethod.invoke(instance);

        Method accelerateMethod = clazz.getMethod("accelerate", int.class);
        accelerateMethod.invoke(instance, 10);

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());

        // Verify the speed is increased by 10
        Method getSpeedMethod = clazz.getMethod("getSpeed");
        int speed = (int) getSpeedMethod.invoke(instance);
        assertEquals(11, speed);
    }

    @Test
    public void testBrake() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level4.implementations.Car");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method startMethod = clazz.getMethod("start");
        startMethod.invoke(instance);

        Method brakeMethod = clazz.getMethod("brake");
        brakeMethod.invoke(instance);

        String output = outputStream.toString().trim();
        assertNotNull(output);
        assertFalse(output.isEmpty());

        // Verify the speed is set to 0
        Method getSpeedMethod = clazz.getMethod("getSpeed");
        int speed = (int) getSpeedMethod.invoke(instance);
        assertEquals(0, speed);
    }
}
