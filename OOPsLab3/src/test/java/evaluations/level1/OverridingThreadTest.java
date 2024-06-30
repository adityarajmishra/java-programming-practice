package evaluations.level1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverridingThreadTest {

    @Test
    public void testRunMethodOverridden() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.OverridingThread");
        Method runMethod = clazz.getMethod("run");
        assertEquals(clazz, runMethod.getDeclaringClass());
    }

    @Test
    public void testStartMethodOverridden() throws Exception {
        Class<?> clazz = Class.forName("evaluations.level1.OverridingThread");
        Method startMethod = clazz.getMethod("start");
        assertEquals(clazz, startMethod.getDeclaringClass());
    }
}
