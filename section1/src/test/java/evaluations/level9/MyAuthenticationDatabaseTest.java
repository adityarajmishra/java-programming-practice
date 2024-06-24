package evaluations.level9;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class MyAuthenticationDatabaseTest {

    @Test
    public void testDatabaseSpecificAuthenticationField() {
        try {
            Class<?> myAuthenticationDatabaseClass = Class.forName("evaluations.level9.MyAuthenticationDatabase");

            // Check for databaseSpecificAuthentication attribute
            Field databaseSpecificAuthenticationField = myAuthenticationDatabaseClass.getDeclaredField("databaseSpecificAuthentication");
            assertEquals(String.class, databaseSpecificAuthenticationField.getType(), "databaseSpecificAuthentication should be of type String.");
            assertEquals(true, Modifier.isPrivate(databaseSpecificAuthenticationField.getModifiers()), "databaseSpecificAuthentication should be private.");
        } catch (ClassNotFoundException e) {
            fail("MyAuthenticationDatabase class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testDatabaseConstructor() {
        try {
            Class<?> myAuthenticationDatabaseClass = Class.forName("evaluations.level9.MyAuthenticationDatabase");

            // Test constructor
            Constructor<?> databaseConstructor = myAuthenticationDatabaseClass.getConstructor(String.class, long.class);
            String databaseAuth = "databaseAuth123";
            long authKey = 987654321L;
            Object databaseInstance = databaseConstructor.newInstance(databaseAuth, authKey);

            // Verify the databaseSpecificAuthentication value
            Field databaseSpecificAuthenticationField = myAuthenticationDatabaseClass.getDeclaredField("databaseSpecificAuthentication");
            databaseSpecificAuthenticationField.setAccessible(true);
            assertEquals(databaseAuth, databaseSpecificAuthenticationField.get(databaseInstance), "databaseSpecificAuthentication should match the constructor argument.");

            // Verify the inherited authenticationKey value
            Field authenticationKeyField = myAuthenticationDatabaseClass.getSuperclass().getDeclaredField("authenticationKey");
            authenticationKeyField.setAccessible(true);
            assertEquals(authKey, authenticationKeyField.getLong(databaseInstance), "authenticationKey should match the constructor argument.");

        } catch (ClassNotFoundException e) {
            fail("MyAuthenticationDatabase class not found.");
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            fail("Field or method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("MyAuthenticationDatabase constructor test failed: " + e.getMessage());
        }
    }

    @Test
    public void testDatabaseInheritance() {
        try {
            Class<?> myAuthenticationDatabaseClass = Class.forName("evaluations.level9.MyAuthenticationDatabase");
            Class<?> myAuthenticationClass = Class.forName("evaluations.level9.MyAuthentication");

            assertTrue(myAuthenticationClass.isAssignableFrom(myAuthenticationDatabaseClass), "MyAuthenticationDatabase should inherit from MyAuthentication");

        } catch (ClassNotFoundException e) {
            fail("Class not found: " + e.getMessage());
        }
    }
}
