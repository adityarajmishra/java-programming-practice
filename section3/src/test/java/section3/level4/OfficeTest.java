package section3.level4;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class OfficeTest {

    @Test
    public void testLocationField() {
        try {
            Class<?> officeClass = Class.forName("section3.level4.Office");
            Field locationField = officeClass.getDeclaredField("location");
            assertEquals(String.class, locationField.getType(), "location should be of type String.");
        } catch (ClassNotFoundException e) {
            fail("Office class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testCapacityField() {
        try {
            Class<?> officeClass = Class.forName("section3.level4.Office");
            Field capacityField = officeClass.getDeclaredField("capacity");
            assertEquals(int.class, capacityField.getType(), "capacity should be of type int.");
        } catch (ClassNotFoundException e) {
            fail("Office class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testWifiPasswordField() {
        try {
            Class<?> officeClass = Class.forName("section3.level4.Office");
            Field wifiPasswordField = officeClass.getDeclaredField("wifiPassword");
            assertEquals(String.class, wifiPasswordField.getType(), "wifiPassword should be of type String.");
        } catch (ClassNotFoundException e) {
            fail("Office class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testLunchProvidedField() {
        try {
            Class<?> officeClass = Class.forName("section3.level4.Office");
            Field lunchProvidedField = officeClass.getDeclaredField("lunchProvided");
            assertEquals(boolean.class, lunchProvidedField.getType(), "lunchProvided should be of type boolean.");
        } catch (ClassNotFoundException e) {
            fail("Office class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testOfficeConstructor() {
        try {
            Class<?> officeClass = Class.forName("section3.level4.Office");
            Constructor<?> officeConstructor = officeClass.getConstructor(String.class, int.class, String.class, boolean.class);
            Object officeInstance = officeConstructor.newInstance("New York", 100, "password123", true);

            Field locationField = officeClass.getDeclaredField("location");
            Field capacityField = officeClass.getDeclaredField("capacity");
            Field wifiPasswordField = officeClass.getDeclaredField("wifiPassword");
            Field lunchProvidedField = officeClass.getDeclaredField("lunchProvided");

            locationField.setAccessible(true);
            capacityField.setAccessible(true);
            wifiPasswordField.setAccessible(true);
            lunchProvidedField.setAccessible(true);

            assertEquals("New York", locationField.get(officeInstance), "location should be New York.");
            assertEquals(100, capacityField.get(officeInstance), "capacity should be 100.");
            assertEquals("password123", wifiPasswordField.get(officeInstance), "wifiPassword should be password123.");
            assertEquals(true, lunchProvidedField.get(officeInstance), "lunchProvided should be true.");
        } catch (ClassNotFoundException e) {
            fail("Office class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Constructor not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Office constructor test failed: " + e.getMessage());
        }
    }

    @Test
    public void testGettersAndSetters() {
        try {
            Class<?> officeClass = Class.forName("section3.level4.Office");
            Constructor<?> officeConstructor = officeClass.getConstructor(String.class, int.class, String.class, boolean.class);
            Object officeInstance = officeConstructor.newInstance("New York", 100, "password123", true);

            Method getLocationMethod = officeClass.getMethod("getLocation");
            Method setLocationMethod = officeClass.getMethod("setLocation", String.class);
            setLocationMethod.invoke(officeInstance, "San Francisco");
            assertEquals("San Francisco", getLocationMethod.invoke(officeInstance), "location should be San Francisco.");

            Method getCapacityMethod = officeClass.getMethod("getCapacity");
            Method setCapacityMethod = officeClass.getMethod("setCapacity", int.class);
            setCapacityMethod.invoke(officeInstance, 150);
            assertEquals(150, getCapacityMethod.invoke(officeInstance), "capacity should be 150.");

            Method getWifiPasswordMethod = officeClass.getMethod("getWifiPassword");
            Method setWifiPasswordMethod = officeClass.getMethod("setWifiPassword", String.class);
            setWifiPasswordMethod.invoke(officeInstance, "newpassword123");
            assertEquals("newpassword123", getWifiPasswordMethod.invoke(officeInstance), "wifiPassword should be newpassword123.");

            Method isLunchProvidedMethod = officeClass.getMethod("isLunchProvided");
            Method setLunchProvidedMethod = officeClass.getMethod("setLunchProvided", boolean.class);
            setLunchProvidedMethod.invoke(officeInstance, false);
            assertEquals(false, isLunchProvidedMethod.invoke(officeInstance), "lunchProvided should be false.");
        } catch (ClassNotFoundException e) {
            fail("Office class not found.");
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Getter and setter test failed: " + e.getMessage());
        }
    }
}
