package section2.level3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {


    @Test
    public void testUserAddressFields() {
        try {
            Class<?> userAddressClass = Class.forName("section2.level3.User$UserAddress");

            // Check for street field
            Field streetField = userAddressClass.getDeclaredField("street");
            assertEquals(String.class, streetField.getType(), "street should be of type String.");
            assertTrue(Modifier.isPublic(streetField.getModifiers()), "street should be public.");

            // Check for city field
            Field cityField = userAddressClass.getDeclaredField("city");
            assertEquals(String.class, cityField.getType(), "city should be of type String.");
            assertTrue(Modifier.isPublic(cityField.getModifiers()), "city should be public.");

            // Check for pinCode field
            Field pinCodeField = userAddressClass.getDeclaredField("pinCode");
            assertEquals(String.class, pinCodeField.getType(), "pinCode should be of type String.");
            assertTrue(Modifier.isPublic(pinCodeField.getModifiers()), "pinCode should be public.");
        } catch (ClassNotFoundException e) {
            fail("UserAddress inner class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testUserAddressConstructor() {
        try {
            Class<?> userAddressClass = Class.forName("section2.level3.User$UserAddress");
            Constructor<?> userAddressConstructor = userAddressClass.getConstructor(String.class, String.class, String.class);
            Object userAddressInstance = userAddressConstructor.newInstance("123 Main St", "Springfield", "12345");

            Field streetField = userAddressClass.getDeclaredField("street");
            Field cityField = userAddressClass.getDeclaredField("city");
            Field pinCodeField = userAddressClass.getDeclaredField("pinCode");

            streetField.setAccessible(true);
            cityField.setAccessible(true);
            pinCodeField.setAccessible(true);

            assertEquals("123 Main St", streetField.get(userAddressInstance), "street should be 123 Main St.");
            assertEquals("Springfield", cityField.get(userAddressInstance), "city should be Springfield.");
            assertEquals("12345", pinCodeField.get(userAddressInstance), "pinCode should be 12345.");
        } catch (ClassNotFoundException e) {
            fail("UserAddress inner class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Constructor not found: " + e.getMessage());
        } catch (Exception e) {
            fail("UserAddress constructor test failed: " + e.getMessage());
        }
    }

    @Test
    public void testUserAddressDisplayAddress() {
        try {
            Class<?> userAddressClass = Class.forName("section2.level3.User$UserAddress");
            Constructor<?> userAddressConstructor = userAddressClass.getConstructor(String.class, String.class, String.class);
            Object userAddressInstance = userAddressConstructor.newInstance("123 Main St", "Springfield", "12345");

            Method displayAddressMethod = userAddressClass.getMethod("displayAddress");

            // Capture System.out output
            java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outContent));

            displayAddressMethod.invoke(userAddressInstance);

            String expectedOutput = "Street: 123 Main St\nCity: Springfield\nZIP: 12345\n";
            assertEquals(expectedOutput, outContent.toString(), "The displayAddress method should print the correct address.");

            // Reset System.out
            System.setOut(System.out);

        } catch (ClassNotFoundException e) {
            fail("UserAddress inner class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("UserAddress displayAddress method test failed: " + e.getMessage());
        }
    }

    @Test
    public void testUserAddressFileRemoved() {
        File file = new File("src/main/java/section2/level3/UserAddress.java");
        assertFalse(file.exists(), "UserAddress.java file should be removed.");
    }
}
