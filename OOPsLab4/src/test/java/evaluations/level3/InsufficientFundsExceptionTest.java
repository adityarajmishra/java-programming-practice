package evaluations.level3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InsufficientFundsExceptionTest {

    @Test
    public void testInsufficientFundsException() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level3.InsufficientFundsException");
        Constructor<?> constructor = clazz.getConstructor(String.class, String.class);
        Object instance = constructor.newInstance("Insufficient funds", "Algorithm123");

        Method getExceptionResolutionAlgorithmMethod = clazz.getMethod("getExceptionResolutionAlgorithm");
        String resolutionAlgorithm = (String) getExceptionResolutionAlgorithmMethod.invoke(instance);

        assertNotNull(instance);
        assertEquals("Insufficient funds", ((Throwable) instance).getMessage());
        assertEquals("Algorithm123", resolutionAlgorithm);
    }
}
