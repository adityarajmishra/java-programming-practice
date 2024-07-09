package evaluations.level2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import static org.junit.jupiter.api.Assertions.*;

class NumberWrapperTest {

    @Test
    void testNumberWrapperIsGenericWithNumberBound() {
        TypeVariable<?>[] typeParameters = NumberWrapper.class.getTypeParameters();
        assertEquals(1, typeParameters.length, "Class should have one type parameter");
        Type[] bounds = typeParameters[0].getBounds();
        assertEquals(1, bounds.length, "Type parameter should have one bound");
        assertEquals(Number.class, bounds[0], "The type parameter should be bounded by Number");
    }

    @Test
    void testSetAndGetContentWithInteger() throws Exception {
        // Create an instance of NumberWrapper<Integer> reflectively
        Constructor<?> constructor = NumberWrapper.class.getDeclaredConstructor();
        Object numberWrapper = constructor.newInstance();

        // Reflectively set content
        Method setContentMethod = NumberWrapper.class.getDeclaredMethod("setContent", Number.class);
        setContentMethod.invoke(numberWrapper, 123);

        // Reflectively get content
        Method getContentMethod = NumberWrapper.class.getDeclaredMethod("getContent");
        Number content = (Number) getContentMethod.invoke(numberWrapper);

        assertEquals(123, content.intValue(), "The content should be set and retrieved correctly as an Integer");
    }

    @Test
    void testSetAndGetContentWithDouble() throws Exception {
        // Create an instance of NumberWrapper<Double> reflectively
        Constructor<?> constructor = NumberWrapper.class.getDeclaredConstructor();
        Object numberWrapper = constructor.newInstance();

        // Reflectively set content
        Method setContentMethod = NumberWrapper.class.getDeclaredMethod("setContent", Number.class);
        setContentMethod.invoke(numberWrapper, 123.45);

        // Reflectively get content
        Method getContentMethod = NumberWrapper.class.getDeclaredMethod("getContent");
        Number content = (Number) getContentMethod.invoke(numberWrapper);

        assertEquals(123.45, content.doubleValue(), "The content should be set and retrieved correctly as a Double");
    }
}
