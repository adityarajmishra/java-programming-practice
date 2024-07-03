package org.skillovilla.level1;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    public void testCar() throws Exception {
        // Test Car methods and number of doors
        Class<?> carClass = Class.forName("org.skillovilla.level1.Car");
        Object car = carClass.getDeclaredConstructor(int.class).newInstance(4);

        Method startMethod = carClass.getMethod("start");
        Method stopMethod = carClass.getMethod("stop");
        Method getNumberOfDoorsMethod = carClass.getMethod("getNumberOfDoors");

        startMethod.invoke(car);
        stopMethod.invoke(car);
        int numberOfDoors = (int) getNumberOfDoorsMethod.invoke(car);

        assertEquals(4, numberOfDoors);
    }

    @Test
    public void testBike() throws Exception {
        // Test Bike methods and carrier
        Class<?> bikeClass = Class.forName("org.skillovilla.level1.Bike");
        Object bike = bikeClass.getDeclaredConstructor(boolean.class).newInstance(true);

        Method startMethod = bikeClass.getMethod("start");
        Method stopMethod = bikeClass.getMethod("stop");
        Method hasCarrierMethod = bikeClass.getMethod("hasCarrier");

        startMethod.invoke(bike);
        stopMethod.invoke(bike);
        boolean hasCarrier = (boolean) hasCarrierMethod.invoke(bike);

        assertTrue(hasCarrier);
    }
}
