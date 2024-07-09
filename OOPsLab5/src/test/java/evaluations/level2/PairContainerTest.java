package evaluations.level2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

import static org.junit.jupiter.api.Assertions.*;

class PairContainerTest {

    @Test
    void testPairContainerIsGeneric() {
        TypeVariable<?>[] typeParameters = PairContainer.class.getTypeParameters();
        assertEquals(2, typeParameters.length, "Class should have two type parameters");
    }

    @Test
    void testSetAndGetFirstValue() throws Exception {
        Constructor<?> constructor = PairContainer.class.getDeclaredConstructor();
        Object pairContainer = constructor.newInstance();

        Method setFirstValueMethod = PairContainer.class.getDeclaredMethod("setFirstValue", Object.class);
        Method getFirstValueMethod = PairContainer.class.getDeclaredMethod("getFirstValue");

        setFirstValueMethod.invoke(pairContainer, "First Value");
        Object firstValue = getFirstValueMethod.invoke(pairContainer);

        assertEquals("First Value", firstValue, "The first value should be set and retrieved correctly");
    }

    @Test
    void testSetAndGetSecondValue() throws Exception {
        Constructor<?> constructor = PairContainer.class.getDeclaredConstructor();
        Object pairContainer = constructor.newInstance();

        Method setSecondValueMethod = PairContainer.class.getDeclaredMethod("setSecondValue", Object.class);
        Method getSecondValueMethod = PairContainer.class.getDeclaredMethod("getSecondValue");

        setSecondValueMethod.invoke(pairContainer, 123);
        Object secondValue = getSecondValueMethod.invoke(pairContainer);

        assertEquals(123, secondValue, "The second value should be set and retrieved correctly");
    }
}
