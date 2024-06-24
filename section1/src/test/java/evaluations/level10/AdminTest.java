package evaluations.level10;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AdminTest {

    @Test
    public void testAdminIdField() {
        try {
            Class<?> adminClass = Class.forName("evaluations.level10.Admin");

            // Check for adminId attribute
            Field adminIdField = adminClass.getDeclaredField("adminId");
            assertEquals(int.class, adminIdField.getType(), "adminId should be of type int.");
            assertEquals(true, Modifier.isPrivate(adminIdField.getModifiers()), "adminId should be private.");
        } catch (ClassNotFoundException e) {
            fail("Admin class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testFirstNameField() {
        try {
            Class<?> adminClass = Class.forName("evaluations.level10.Admin");

            // Check for firstName attribute
            Field firstNameField = adminClass.getDeclaredField("firstName");
            assertEquals(String.class, firstNameField.getType(), "firstName should be of type String.");
            assertEquals(true, Modifier.isPrivate(firstNameField.getModifiers()), "firstName should be private.");
        } catch (ClassNotFoundException e) {
            fail("Admin class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testLastNameField() {
        try {
            Class<?> adminClass = Class.forName("evaluations.level10.Admin");

            // Check for lastName attribute
            Field lastNameField = adminClass.getDeclaredField("lastName");
            assertEquals(String.class, lastNameField.getType(), "lastName should be of type String.");
            assertEquals(true, Modifier.isPrivate(lastNameField.getModifiers()), "lastName should be private.");
        } catch (ClassNotFoundException e) {
            fail("Admin class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testAuthorisedField() {
        try {
            Class<?> adminClass = Class.forName("evaluations.level10.Admin");

            // Check for authorised attribute
            Field authorisedField = adminClass.getDeclaredField("authorised");
            assertEquals(boolean.class, authorisedField.getType(), "authorised should be of type boolean.");
            assertEquals(true, Modifier.isPrivate(authorisedField.getModifiers()), "authorised should be private.");
        } catch (ClassNotFoundException e) {
            fail("Admin class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testConstructor() {
        try {
            Class<?> adminClass = Class.forName("evaluations.level10.Admin");

            // Test constructor
            Constructor<?> adminConstructor = adminClass.getConstructor(int.class, String.class, String.class, boolean.class);
            int adminId = 1;
            String firstName = "John";
            String lastName = "Doe";
            boolean authorised = true;
            Object adminInstance = adminConstructor.newInstance(adminId, firstName, lastName, authorised);

            // Verify the fields
            Field adminIdField = adminClass.getDeclaredField("adminId");
            adminIdField.setAccessible(true);
            assertEquals(adminId, adminIdField.getInt(adminInstance), "adminId should match the constructor argument.");

            Field firstNameField = adminClass.getDeclaredField("firstName");
            firstNameField.setAccessible(true);
            assertEquals(firstName, firstNameField.get(adminInstance), "firstName should match the constructor argument.");

            Field lastNameField = adminClass.getDeclaredField("lastName");
            lastNameField.setAccessible(true);
            assertEquals(lastName, lastNameField.get(adminInstance), "lastName should match the constructor argument.");

            Field authorisedField = adminClass.getDeclaredField("authorised");
            authorisedField.setAccessible(true);
            assertEquals(authorised, authorisedField.getBoolean(adminInstance), "authorised should match the constructor argument.");

        } catch (ClassNotFoundException e) {
            fail("Admin class not found.");
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            fail("Field or method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("Admin constructor test failed: " + e.getMessage());
        }
    }

    @Test
    public void testAdminIdGettersAndSetters() {
        try {
            Class<?> adminClass = Class.forName("evaluations.level10.Admin");
            Constructor<?> adminConstructor = adminClass.getConstructor(int.class, String.class, String.class, boolean.class);
            Object adminInstance = adminConstructor.newInstance(1, "John", "Doe", true);

            Method getAdminId = adminClass.getMethod("getAdminId");
            assertEquals(1, getAdminId.invoke(adminInstance), "getAdminId should return the correct value.");

            Method setAdminId = adminClass.getMethod("setAdminId", int.class);
            setAdminId.invoke(adminInstance, 2);

            assertEquals(2, getAdminId.invoke(adminInstance), "setAdminId should set the correct value.");
        } catch (Exception e) {
            fail("testAdminIdGettersAndSetters failed: " + e.getMessage());
        }
    }

    @Test
    public void testFirstNameGettersAndSetters() {
        try {
            Class<?> adminClass = Class.forName("evaluations.level10.Admin");
            Constructor<?> adminConstructor = adminClass.getConstructor(int.class, String.class, String.class, boolean.class);
            Object adminInstance = adminConstructor.newInstance(1, "John", "Doe", true);

            Method getFirstName = adminClass.getMethod("getFirstName");
            assertEquals("John", getFirstName.invoke(adminInstance), "getFirstName should return the correct value.");

            Method setFirstName = adminClass.getMethod("setFirstName", String.class);
            setFirstName.invoke(adminInstance, "Jane");

            assertEquals("Jane", getFirstName.invoke(adminInstance), "setFirstName should set the correct value.");
        } catch (Exception e) {
            fail("testFirstNameGettersAndSetters failed: " + e.getMessage());
        }
    }

    @Test
    public void testLastNameGettersAndSetters() {
        try {
            Class<?> adminClass = Class.forName("evaluations.level10.Admin");
            Constructor<?> adminConstructor = adminClass.getConstructor(int.class, String.class, String.class, boolean.class);
            Object adminInstance = adminConstructor.newInstance(1, "John", "Doe", true);

            Method getLastName = adminClass.getMethod("getLastName");
            assertEquals("Doe", getLastName.invoke(adminInstance), "getLastName should return the correct value.");

            Method setLastName = adminClass.getMethod("setLastName", String.class);
            setLastName.invoke(adminInstance, "Smith");

            assertEquals("Smith", getLastName.invoke(adminInstance), "setLastName should set the correct value.");
        } catch (Exception e) {
            fail("testLastNameGettersAndSetters failed: " + e.getMessage());
        }
    }

    @Test
    public void testAuthorisedGettersAndSetters() {
        try {
            Class<?> adminClass = Class.forName("evaluations.level10.Admin");
            Constructor<?> adminConstructor = adminClass.getConstructor(int.class, String.class, String.class, boolean.class);
            Object adminInstance = adminConstructor.newInstance(1, "John", "Doe", true);

            Method isAuthorised = adminClass.getMethod("isAuthorised");
            assertEquals(true, isAuthorised.invoke(adminInstance), "isAuthorised should return the correct value.");

            Method setAuthorised = adminClass.getMethod("setAuthorised", boolean.class);
            setAuthorised.invoke(adminInstance, false);

            assertEquals(false, isAuthorised.invoke(adminInstance), "setAuthorised should set the correct value.");
        } catch (Exception e) {
            fail("testAuthorisedGettersAndSetters failed: " + e.getMessage());
        }
    }
}
