package org.skillovilla.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Class<?> carClass;
    private Class<?> bikeClass;
    private Object car;
    private Object bike;

    @BeforeEach
    void setUp() throws Exception {
        carClass = Class.forName("org.skillovilla.level2.Car");
        car = carClass.getDeclaredConstructor(String.class, String.class, int.class)
                      .newInstance("Toyota", "Camry", 4);

        bikeClass = Class.forName("org.skillovilla.level2.Bike");
        bike = bikeClass.getDeclaredConstructor(String.class, String.class, int.class)
                        .newInstance("Yamaha", "YZF-R3", 2);
    }

    @Test
    void testCarBrand() throws Exception {
        // Test Car brand
        Method getBrandMethod = carClass.getMethod("getBrand");
        assertEquals("Toyota", getBrandMethod.invoke(car));
    }

    @Test
    void testCarModel() throws Exception {
        // Test Car model
        Method getModelMethod = carClass.getMethod("getModel");
        assertEquals("Camry", getModelMethod.invoke(car));
    }

    @Test
    void testCarNumberOfWheels() throws Exception {
        // Test Car number of wheels
        Method getNumberOfWheelsMethod = carClass.getMethod("getNumberOfWheels");
        assertEquals(4, getNumberOfWheelsMethod.invoke(car));
    }

    @Test
    void testBikeBrand() throws Exception {
        // Test Bike brand
        Method getBrandMethod = bikeClass.getMethod("getBrand");
        assertEquals("Yamaha", getBrandMethod.invoke(bike));
    }

    @Test
    void testBikeModel() throws Exception {
        // Test Bike model
        Method getModelMethod = bikeClass.getMethod("getModel");
        assertEquals("YZF-R3", getModelMethod.invoke(bike));
    }

    @Test
    void testBikeNumberOfWheels() throws Exception {
        // Test Bike number of wheels
        Method getNumberOfWheelsMethod = bikeClass.getMethod("getNumberOfWheels");
        assertEquals(2, getNumberOfWheelsMethod.invoke(bike));
    }
}
