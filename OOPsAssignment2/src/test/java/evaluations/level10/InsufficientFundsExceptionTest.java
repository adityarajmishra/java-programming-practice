package evaluations.level10;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class InsufficientFundsExceptionTest {

    @Test
    public void testConstructorAndGetters() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level10.InsufficientFundsException");
        Constructor<?> constructor = clazz.getConstructor(double.class, String.class);
        Object instance = constructor.newInstance(100.0, "Insufficient funds");

        Method getBalanceMethod = clazz.getMethod("getBalance");
        Method getMessageMethod = clazz.getMethod("getMessage");

        double balance = (double) getBalanceMethod.invoke(instance);
        String message = (String) getMessageMethod.invoke(instance);

        assertEquals(100.0, balance);
        assertEquals("Insufficient funds", message);
    }

    @Test
    public void testGetSuggestion() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level10.InsufficientFundsException");
        Constructor<?> constructor = clazz.getConstructor(double.class, String.class);
        Object instance = constructor.newInstance(100.0, "Insufficient funds");

        Method getSuggestionMethod = clazz.getMethod("getSuggestion");

        String suggestion = (String) getSuggestionMethod.invoke(instance);

        assertNotNull(suggestion);
        assertFalse(suggestion.isEmpty());
    }
}
