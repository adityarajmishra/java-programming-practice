package evaluations.level9;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MyAuthenticationServerTest {

    @Test
    public void testServerSpecificAuthenticationField() {
        try {
            Class<?> myAuthenticationServerClass = Class.forName("evaluations.level9.MyAuthenticationServer");

            // Check for serverSpecificAuthentication attribute
            Field serverSpecificAuthenticationField = myAuthenticationServerClass.getDeclaredField("serverSpecificAuthentication");
            assertEquals(String.class, serverSpecificAuthenticationField.getType(), "serverSpecificAuthentication should be of type String.");
            assertEquals(true, Modifier.isPrivate(serverSpecificAuthenticationField.getModifiers()), "serverSpecificAuthentication should be private.");
        } catch (ClassNotFoundException e) {
            fail("MyAuthenticationServer class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testServerConstructor() {
        try {
            Class<?> myAuthenticationServerClass = Class.forName("evaluations.level9.MyAuthenticationServer");

            // Test constructor
            Constructor<?> serverConstructor = myAuthenticationServerClass.getConstructor(String.class, long.class);
            String serverAuth = "serverAuth123";
            long authKey = 123456789L;
            Object serverInstance = serverConstructor.newInstance(serverAuth, authKey);

            // Verify the serverSpecificAuthentication value
            Field serverSpecificAuthenticationField = myAuthenticationServerClass.getDeclaredField("serverSpecificAuthentication");
            serverSpecificAuthenticationField.setAccessible(true);
            assertEquals(serverAuth, serverSpecificAuthenticationField.get(serverInstance), "serverSpecificAuthentication should match the constructor argument.");

            // Verify the inherited authenticationKey value
            Field authenticationKeyField = myAuthenticationServerClass.getSuperclass().getDeclaredField("authenticationKey");
            authenticationKeyField.setAccessible(true);
            assertEquals(authKey, authenticationKeyField.getLong(serverInstance), "authenticationKey should match the constructor argument.");

        } catch (ClassNotFoundException e) {
            fail("MyAuthenticationServer class not found.");
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            fail("Field or method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("MyAuthenticationServer constructor test failed: " + e.getMessage());
        }
    }
}
