package evaluations.level6;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CatFamilyTest {

    @Test
    public void testLionInheritance() {
        try {
            // Check if Lion class exists
            Class<?> lionClass = Class.forName("evaluations.level6.Lion");

            // Test Lion class inheritance
            assertEquals(Class.forName("evaluations.level6.CatFamily"), lionClass.getSuperclass(), "Lion class should inherit from CatFamily class.");

            // Check for maneColor attribute
            Field maneColorField = lionClass.getDeclaredField("maneColor");
            assertEquals(String.class, maneColorField.getType(), "maneColor should be of type String.");

            // Test Lion constructor and methods
            Constructor<?> lionConstructor = lionClass.getConstructor(String.class, int.class, String.class, int.class);
            Object lionInstance = lionConstructor.newInstance("Golden", 5, "Savannah", 200);

            // Check if maneColor is correctly assigned
            maneColorField.setAccessible(true);
            assertEquals("Golden", maneColorField.get(lionInstance), "maneColor should be Golden.");

            // Test printManeColor method
            Method printManeColorMethod = lionClass.getMethod("printManeColor");
            printManeColorMethod.invoke(lionInstance); // Should print "My mane color is: Golden"

        } catch (ClassNotFoundException e) {
            fail("Lion class not found.");
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            fail("Field or method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Lion inheritance test failed: " + e.getMessage());
        }
    }

    @Test
    public void testTigerInheritance() {
        try {
            // Check if Tiger class exists
            Class<?> tigerClass = Class.forName("evaluations.level6.Tiger");

            // Test Tiger class inheritance
            assertEquals(Class.forName("evaluations.level6.CatFamily"), tigerClass.getSuperclass(), "Tiger class should inherit from CatFamily class.");

            // Check for stripePattern attribute
            Field stripePatternField = tigerClass.getDeclaredField("stripePattern");
            assertEquals(String.class, stripePatternField.getType(), "stripePattern should be of type String.");

            // Test Tiger constructor and methods
            Constructor<?> tigerConstructor = tigerClass.getConstructor(String.class, int.class, String.class, int.class);
            Object tigerInstance = tigerConstructor.newInstance("Striped", 3, "Jungle", 220);

            // Check if stripePattern is correctly assigned
            stripePatternField.setAccessible(true);
            assertEquals("Striped", stripePatternField.get(tigerInstance), "stripePattern should be Striped.");

            // Test printStripePattern method
            Method printStripePatternMethod = tigerClass.getMethod("printStripePattern");
            printStripePatternMethod.invoke(tigerInstance); // Should print "My stripe pattern is: Striped"

        } catch (ClassNotFoundException e) {
            fail("Tiger class not found.");
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            fail("Field or method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Tiger inheritance test failed: " + e.getMessage());
        }
    }

    @Test
    public void testCatFamilyCommonProperties() {
        try {
            // Check if CatFamily class exists
            Class<?> catFamilyClass = Class.forName("evaluations.level6.CatFamily");

            // Test CatFamily constructor and methods
            Constructor<?> catFamilyConstructor = catFamilyClass.getConstructor(int.class, String.class, int.class);
            Object catFamilyInstance = catFamilyConstructor.newInstance(4, "Forest", 150);

            // Check for age, location, and weight attributes
            Field ageField = catFamilyClass.getDeclaredField("age");
            Field locationField = catFamilyClass.getDeclaredField("location");
            Field weightField = catFamilyClass.getDeclaredField("weight");

            ageField.setAccessible(true);
            locationField.setAccessible(true);
            weightField.setAccessible(true);

            assertEquals(4, ageField.get(catFamilyInstance), "Age should be 4.");
            assertEquals("Forest", locationField.get(catFamilyInstance), "Location should be Forest.");
            assertEquals(150, weightField.get(catFamilyInstance), "Weight should be 150.");

            // Test commonProperties method
            Method commonPropertiesMethod = catFamilyClass.getMethod("commonProperties");
            commonPropertiesMethod.invoke(catFamilyInstance); // Should print "Age: 4, Location: Forest and Weight: 150"

        } catch (ClassNotFoundException e) {
            fail("CatFamily class not found.");
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            fail("Field or method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("CatFamily test failed: " + e.getMessage());
        }
    }
}
