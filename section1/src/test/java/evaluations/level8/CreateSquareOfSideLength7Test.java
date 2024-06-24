package evaluations.level8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CreateSquareOfSideLength7Test {

    @BeforeEach
    public void resetStaticCounters() {
        try {
            Class<?> squareClass = Class.forName("evaluations.level8.CreateSquareOfSideLength7");
            Field numberOfSquaresCreatedField = squareClass.getDeclaredField("numberOfSquaresCreated");
            numberOfSquaresCreatedField.setAccessible(true);
            numberOfSquaresCreatedField.setInt(null, 0);
        } catch (Exception e) {
            fail("Failed to reset static counters: " + e.getMessage());
        }
    }

    @Test
    public void testSizeField() {
        try {
            Class<?> squareClass = Class.forName("evaluations.level8.CreateSquareOfSideLength7");
            Field sizeField = squareClass.getDeclaredField("size");
            assertEquals(int.class, sizeField.getType(), "size should be of type int.");
            assertEquals(true, Modifier.isFinal(sizeField.getModifiers()), "size should be final.");

            Constructor<?> squareConstructor = squareClass.getConstructor(long.class);
            Object squareInstance = squareConstructor.newInstance(System.currentTimeMillis());

            sizeField.setAccessible(true);
            assertEquals(7, sizeField.getInt(squareInstance), "size should be 7.");
        } catch (Exception e) {
            fail("testSizeField failed: " + e.getMessage());
        }
    }

    @Test
    public void testNumberOfSquaresCreatedField() {
        try {
            Class<?> squareClass = Class.forName("evaluations.level8.CreateSquareOfSideLength7");
            Field numberOfSquaresCreatedField = squareClass.getDeclaredField("numberOfSquaresCreated");
            assertEquals(int.class, numberOfSquaresCreatedField.getType(), "numberOfSquaresCreated should be of type int.");
            assertEquals(true, Modifier.isStatic(numberOfSquaresCreatedField.getModifiers()), "numberOfSquaresCreated should be static.");

            Constructor<?> squareConstructor = squareClass.getConstructor(long.class);
            squareConstructor.newInstance(System.currentTimeMillis());
            assertEquals(1, numberOfSquaresCreatedField.getInt(null), "numberOfSquaresCreated should be incremented.");
        } catch (Exception e) {
            fail("testNumberOfSquaresCreatedField failed: " + e.getMessage());
        }
    }

    @Test
    public void testNumberOfSidesField() {
        try {
            Class<?> squareClass = Class.forName("evaluations.level8.CreateSquareOfSideLength7");
            Field numberOfSidesField = squareClass.getDeclaredField("NUMBER_OF_SIDES");
            assertEquals(int.class, numberOfSidesField.getType(), "NUMBER_OF_SIDES should be of type int.");
            assertEquals(4, numberOfSidesField.getInt(null), "NUMBER_OF_SIDES should be 4.");
            assertEquals(true, Modifier.isStatic(numberOfSidesField.getModifiers()), "NUMBER_OF_SIDES should be static.");
            assertEquals(true, Modifier.isFinal(numberOfSidesField.getModifiers()), "NUMBER_OF_SIDES should be final.");
        } catch (Exception e) {
            fail("testNumberOfSidesField failed: " + e.getMessage());
        }
    }

    @Test
    public void testTimeOfCreationField() {
        try {
            Class<?> squareClass = Class.forName("evaluations.level8.CreateSquareOfSideLength7");
            Field timeOfCreationField = squareClass.getDeclaredField("timeOfCreation");
            assertEquals(long.class, timeOfCreationField.getType(), "timeOfCreation should be of type long.");
            assertEquals(true, Modifier.isFinal(timeOfCreationField.getModifiers()), "timeOfCreation should be final.");

            long currentTime = System.currentTimeMillis();
            Constructor<?> squareConstructor = squareClass.getConstructor(long.class);
            Object squareInstance = squareConstructor.newInstance(currentTime);

            timeOfCreationField.setAccessible(true);
            assertEquals(currentTime, timeOfCreationField.getLong(squareInstance), "timeOfCreation should match the constructor argument.");
        } catch (Exception e) {
            fail("testTimeOfCreationField failed: " + e.getMessage());
        }
    }
}
