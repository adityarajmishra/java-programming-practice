package evaluations.level3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandleCustomExceptionsTest {

    @Test
    public void testInsufficientFundsException() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level3.HandleCustomExceptions");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        Method insufficientFundsExceptionMethod = clazz.getMethod("insufficientFundsException", String.class, String.class);

        InvocationTargetException thrown = assertThrows(InvocationTargetException.class, () -> {
            insufficientFundsExceptionMethod.invoke(instance, "Insufficient funds", "Algorithm123");
        });

        Throwable cause = thrown.getCause();
        assertEquals("evaluations.level3.InsufficientFundsException", cause.getClass().getName());
        assertEquals("Insufficient funds", cause.getMessage());

        Method getExceptionResolutionAlgorithmMethod = cause.getClass().getMethod("getExceptionResolutionAlgorithm");
        String resolutionAlgorithm = (String) getExceptionResolutionAlgorithmMethod.invoke(cause);
        assertEquals("Algorithm123", resolutionAlgorithm);
    }

}
