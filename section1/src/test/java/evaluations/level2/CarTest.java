package evaluations.level2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    public void testConstructorAndFields() throws Exception {
        Class<?> carClass = Class.forName("evaluations.level2.Car");
        Constructor<?> constructor = carClass.getConstructor(int.class, String.class);
        Object car = constructor.newInstance(4, "Blue");

        Field noOfTyresField = carClass.getDeclaredField("noOfTyres");
        noOfTyresField.setAccessible(true);
        assertEquals(4, noOfTyresField.getInt(car), "The number of tyres should be 4");

        Field colorField = carClass.getDeclaredField("color");
        colorField.setAccessible(true);
        assertEquals("Blue", colorField.get(car), "The color should be Blue");
    }
}