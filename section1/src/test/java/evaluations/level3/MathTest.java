package evaluations.level3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    @Test
    public void testAlgebraClassMethods() {

        try {
            Method defineMethodInAlgebra = Algebra.class.getMethod("define");
            assertEquals(Math.class, defineMethodInAlgebra.getDeclaringClass(), "Algebra class should inherit define method from Math class.");
        } catch (NoSuchMethodException e) {
            fail("Inheritance test failed: " + e.getMessage());
        }

    }

    @Test
    public void testTrigonometryClassMethods() {
        try {
            Method defineMethodInTrigonometry = Trigonometry.class.getMethod("define");
            assertEquals(Math.class, defineMethodInTrigonometry.getDeclaringClass(), "Trigonometry class should inherit define method from Math class.");
        } catch (NoSuchMethodException e) {
            fail("Inheritance test failed: " + e.getMessage());
        }
    }
}