package section2.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @BeforeEach
    public void resetNumberOfCarsCreated() throws NoSuchFieldException, IllegalAccessException {
        // Reset the static variable before each test
        Field numberOfCarsCreatedField = Car.class.getDeclaredField("numberOfCarsCreated");
        numberOfCarsCreatedField.setAccessible(true);
        numberOfCarsCreatedField.set(null, 0);
    }

    @Test
    public void testModelField() {
        try {
            Class<?> carClass = Class.forName("section2.level2.Car");

            // Check for model field
            Field modelField = carClass.getDeclaredField("model");
            assertEquals(String.class, modelField.getType(), "model should be of type String.");
            assertTrue(Modifier.isPublic(modelField.getModifiers()), "model should be public.");
            assertTrue(Modifier.isFinal(modelField.getModifiers()), "model should be final.");
        } catch (ClassNotFoundException e) {
            fail("Car class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testBrandField() {
        try {
            Class<?> carClass = Class.forName("section2.level2.Car");

            // Check for brand field
            Field brandField = carClass.getDeclaredField("brand");
            assertEquals(String.class, brandField.getType(), "brand should be of type String.");
            assertTrue(Modifier.isPublic(brandField.getModifiers()), "brand should be public.");
            assertTrue(Modifier.isFinal(brandField.getModifiers()), "brand should be final.");
        } catch (ClassNotFoundException e) {
            fail("Car class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testNumberOfTyresField() {
        try {
            Class<?> carClass = Class.forName("section2.level2.Car");

            // Check for numberOfTyres field
            Field numberOfTyresField = carClass.getDeclaredField("numberOfTyres");
            assertEquals(int.class, numberOfTyresField.getType(), "numberOfTyres should be of type int.");
            assertTrue(Modifier.isPublic(numberOfTyresField.getModifiers()), "numberOfTyres should be public.");
        } catch (ClassNotFoundException e) {
            fail("Car class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testMileageField() {
        try {
            Class<?> carClass = Class.forName("section2.level2.Car");

            // Check for mileage field
            Field mileageField = carClass.getDeclaredField("mileage");
            assertEquals(int.class, mileageField.getType(), "mileage should be of type int.");
            assertTrue(Modifier.isPublic(mileageField.getModifiers()), "mileage should be public.");
        } catch (ClassNotFoundException e) {
            fail("Car class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testNumberOfCarsCreatedField() {
        try {
            Class<?> carClass = Class.forName("section2.level2.Car");

            // Check for numberOfCarsCreated field
            Field numberOfCarsCreatedField = carClass.getDeclaredField("numberOfCarsCreated");
            assertEquals(int.class, numberOfCarsCreatedField.getType(), "numberOfCarsCreated should be of type int.");
            assertTrue(Modifier.isPublic(numberOfCarsCreatedField.getModifiers()), "numberOfCarsCreated should be public.");
            assertTrue(Modifier.isStatic(numberOfCarsCreatedField.getModifiers()), "numberOfCarsCreated should be static.");
        } catch (ClassNotFoundException e) {
            fail("Car class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testManufacturedByField() {
        try {
            Class<?> carClass = Class.forName("section2.level2.Car");

            // Check for MANUFACTURED_BY field
            Field manufacturedByField = carClass.getDeclaredField("MANUFACTURED_BY");
            assertEquals(String.class, manufacturedByField.getType(), "MANUFACTURED_BY should be of type String.");
            assertTrue(Modifier.isPublic(manufacturedByField.getModifiers()), "MANUFACTURED_BY should be public.");
            assertTrue(Modifier.isStatic(manufacturedByField.getModifiers()), "MANUFACTURED_BY should be static.");
            assertTrue(Modifier.isFinal(manufacturedByField.getModifiers()), "MANUFACTURED_BY should be final.");
        } catch (ClassNotFoundException e) {
            fail("Car class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testCarConstructor() {
        try {
            Class<?> carClass = Class.forName("section2.level2.Car");
            Constructor<?> carConstructor = carClass.getConstructor(String.class, String.class, int.class, int.class);
            Object carInstance = carConstructor.newInstance("Model S", "Tesla", 4, 500);

            Field modelField = carClass.getDeclaredField("model");
            Field brandField = carClass.getDeclaredField("brand");
            Field numberOfTyresField = carClass.getDeclaredField("numberOfTyres");
            Field mileageField = carClass.getDeclaredField("mileage");
            Field numberOfCarsCreatedField = carClass.getDeclaredField("numberOfCarsCreated");

            modelField.setAccessible(true);
            brandField.setAccessible(true);
            numberOfTyresField.setAccessible(true);
            mileageField.setAccessible(true);
            numberOfCarsCreatedField.setAccessible(true);

            assertEquals("Model S", modelField.get(carInstance), "model should be Model S.");
            assertEquals("Tesla", brandField.get(carInstance), "brand should be Tesla.");
            assertEquals(4, numberOfTyresField.get(carInstance), "numberOfTyres should be 4.");
            assertEquals(500, mileageField.get(carInstance), "mileage should be 500.");
            assertEquals(1, numberOfCarsCreatedField.get(null), "numberOfCarsCreated should be 1.");

        } catch (ClassNotFoundException e) {
            fail("Car class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Constructor not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Car constructor test failed: " + e.getMessage());
        }
    }
}
