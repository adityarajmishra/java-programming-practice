package evaluations.level9;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MyAuthenticationTest {

    @Test
    public void testAuthenticationKeyField() {
        try {
            Class<?> myAuthenticationClass = Class.forName("evaluations.level9.MyAuthentication");

            // Check for authenticationKey attribute
            Field authenticationKeyField = myAuthenticationClass.getDeclaredField("authenticationKey");
            assertEquals(long.class, authenticationKeyField.getType(), "authenticationKey should be of type long.");
            assertEquals(true, Modifier.isProtected(authenticationKeyField.getModifiers()), "authenticationKey should be protected.");
        } catch (ClassNotFoundException e) {
            fail("MyAuthentication class not found.");
        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        }
    }

    @Test
    public void testAuthenticationConstructor() {
        try {
            Class<?> myAuthenticationClass = Class.forName("evaluations.level9.MyAuthentication");

            // Test constructor
            Constructor<?> authenticationConstructor = myAuthenticationClass.getConstructor(long.class);
            long authKey = 123456789L;
            Object authenticationInstance = authenticationConstructor.newInstance(authKey);

            // Verify the authenticationKey value
            Field authenticationKeyField = myAuthenticationClass.getDeclaredField("authenticationKey");
            authenticationKeyField.setAccessible(true);
            assertEquals(authKey, authenticationKeyField.getLong(authenticationInstance), "authenticationKey should match the constructor argument.");

        } catch (ClassNotFoundException e) {
            fail("MyAuthentication class not found.");
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            fail("Field or method not found: " + e.getMessage());
        } catch (Exception e) {
            fail("MyAuthentication constructor test failed: " + e.getMessage());
        }
    }
}
