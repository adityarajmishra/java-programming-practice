package evaluations.level5;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class GroceryTest {

    @Test
    public void testMilkInheritance() {
        // Test Milk class inheritance
        Milk milkInstance = new Milk(20, "BrandB", true);
        assertEquals(20, milkInstance.price, "Price should be 20.");
        assertEquals("BrandB", milkInstance.brand, "Brand should be BrandB.");
        assertTrue(milkInstance.isFullCream, "isFullCream should be true.");

        // Verify that Milk is a subclass of Grocery
        assertEquals(Grocery.class, milkInstance.getClass().getSuperclass(), "Milk class should inherit from Grocery class.");
    }

    @Test
    public void testSugarInheritance() {
        // Test Sugar class inheritance
        Sugar sugarInstance = new Sugar(15, "BrandC", false);
        assertEquals(15, sugarInstance.price, "Price should be 15.");
        assertEquals("BrandC", sugarInstance.brand, "Brand should be BrandC.");
        assertFalse(sugarInstance.isCrystalized, "isCrystalized should be false.");

        // Verify that Sugar is a subclass of Grocery
        assertEquals(Grocery.class, sugarInstance.getClass().getSuperclass(), "Sugar class should inherit from Grocery class.");
    }
    @Test
    public void testBreadInheritanceAndField() {
        try {
            // Check if Bread class exists
            Class<?> breadClass = Class.forName("evaluations.level5.Bread");

            // Test Bread class inheritance
            assertEquals(Class.forName("evaluations.level5.Grocery"), breadClass.getSuperclass(), "Bread class should inherit from Grocery class.");

            // Check for isExpired attribute
            Field isExpiredField = breadClass.getDeclaredField("isExpired");
            assertEquals(boolean.class, isExpiredField.getType(), "isExpired should be of type boolean.");

        } catch (ClassNotFoundException e) {
            fail("Bread class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testBreadConstructorAndFields() {
        try {
            // Check if Bread class exists
            Class<?> breadClass = Class.forName("evaluations.level5.Bread");

            // Test Bread constructor
            Constructor<?> breadConstructor = breadClass.getConstructor(int.class, String.class, boolean.class);
            Object breadInstance = breadConstructor.newInstance(10, "BrandA", true);

            // Check if price, brand and isExpired are correctly assigned
            Field priceField = breadClass.getSuperclass().getDeclaredField("price");
            Field brandField = breadClass.getSuperclass().getDeclaredField("brand");
            Field isExpiredField = breadClass.getDeclaredField("isExpired");

            priceField.setAccessible(true);
            brandField.setAccessible(true);
            isExpiredField.setAccessible(true);

            assertEquals(10, priceField.get(breadInstance), "Price should be 10.");
            assertEquals("BrandA", brandField.get(breadInstance), "Brand should be BrandA.");
            assertEquals(true, isExpiredField.get(breadInstance), "isExpired should be true.");

        } catch (ClassNotFoundException e) {
            fail("Bread class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Constructor not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Bread constructor test failed: " + e.getMessage());
        }
    }
}