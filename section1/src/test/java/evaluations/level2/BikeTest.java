package evaluations.level2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class BikeTest {

    @Test
    public void testConstructorAndFields() throws Exception {
        Class<?> bikeClass = Class.forName("evaluations.level2.Bike");
        Constructor<?> constructor = bikeClass.getConstructor(int.class, String.class);
        Object bike = constructor.newInstance(2, "Black");

        Field noOfTyresField = bikeClass.getDeclaredField("noOfTyres");
        noOfTyresField.setAccessible(true);
        assertEquals(2, noOfTyresField.getInt(bike), "The number of tyres should be 2");

        Field colorField = bikeClass.getDeclaredField("color");
        colorField.setAccessible(true);
        assertEquals("Black", colorField.get(bike), "The color should be Black");
    }

}