package section2.level2.workshop;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MechanicalTest {

    @Test
    public void testPaintMethod() {
        try {
            // Use reflection to create Car object
            Class<?> carClass = Class.forName("section2.level2.Car");
            Constructor<?> carConstructor = carClass.getConstructor(String.class, String.class, int.class, int.class);
            Object car = carConstructor.newInstance("Model X", "Tesla", 4, 400);

            // Use reflection to create Mechanical object
            Class<?> mechanicalClass = Class.forName("section2.level2.workshop.Mechanical");
            Object mechanical = mechanicalClass.getDeclaredConstructor().newInstance();

            // Use reflection to get the paint method
            Method paintMethod = mechanicalClass.getMethod("paint", carClass);

            // Capture System.out output
            java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outContent));

            // Invoke the paint method
            paintMethod.invoke(mechanical, car);

            assertEquals("Painting: Model X\n", outContent.toString(), "The paint method should print 'Painting: Model X'.");

            // Reset System.out
            System.setOut(System.out);

        } catch (Exception e) {
            fail("Mechanical paint method test failed: " + e.getMessage());
        }
    }

    @Test
    public void testAddTyresMethod() {
        try {
            // Use reflection to create Car object
            Class<?> carClass = Class.forName("section2.level2.Car");
            Constructor<?> carConstructor = carClass.getConstructor(String.class, String.class, int.class, int.class);
            Object car = carConstructor.newInstance("Model 3", "Tesla", 4, 300);

            // Use reflection to get the addTyres method
            Class<?> mechanicalClass = Class.forName("section2.level2.workshop.Mechanical");
            Method addTyresMethod = mechanicalClass.getMethod("addTyres", carClass);

            // Capture System.out output
            java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outContent));

            // Invoke the addTyres method
            addTyresMethod.invoke(null, car);

            // Access the numberOfTyres field using reflection
            Field numberOfTyresField = carClass.getDeclaredField("numberOfTyres");
            numberOfTyresField.setAccessible(true);

            assertEquals(6, numberOfTyresField.getInt(car), "The addTyres method should add 2 tyres to the car.");
            assertEquals("Added tyres to: Model 3\n", outContent.toString(), "The addTyres method should print 'Added tyres to: Model 3'.");

            // Reset System.out
            System.setOut(System.out);

        } catch (Exception e) {
            fail("Mechanical addTyres method test failed: " + e.getMessage());
        }
    }
}
