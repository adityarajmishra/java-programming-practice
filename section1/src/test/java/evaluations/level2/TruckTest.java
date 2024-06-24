package evaluations.level2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    @Test
    public void testConstructorAndFields() throws Exception {
        Class<?> truckClass = Class.forName("evaluations.level2.Truck");
        Constructor<?> constructor = truckClass.getConstructor(int.class, String.class);
        Object truck = constructor.newInstance(6, "Red");

        Field noOfTyresField = truckClass.getDeclaredField("noOfTyres");
        noOfTyresField.setAccessible(true);
        assertEquals(6, noOfTyresField.getInt(truck), "The number of tyres should be 6");

        Field colorField = truckClass.getDeclaredField("color");
        colorField.setAccessible(true);
        assertEquals("Red", colorField.get(truck), "The color should be Red");
    }

}