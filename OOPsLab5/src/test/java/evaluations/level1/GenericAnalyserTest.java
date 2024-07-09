package evaluations.level1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

import static org.junit.jupiter.api.Assertions.*;

class GenericAnalyserTest {

    @Test
    void testGenericAnalyserIsGeneric() {
        TypeVariable<?>[] typeParameters = GenericAnalyser.class.getTypeParameters();
        assertEquals(1, typeParameters.length, "Class should have one type parameter");
    }

    @Test
    void testAddValue() throws Exception {
        Constructor<?> constructor = GenericAnalyser.class.getDeclaredConstructor(int.class);
        Object analyser = constructor.newInstance(5);

        Method addValueMethod = GenericAnalyser.class.getDeclaredMethod("addValue", Object.class);
        boolean result1 = (boolean) addValueMethod.invoke(analyser, "test1");
        boolean result2 = (boolean) addValueMethod.invoke(analyser, "test2");

        assertTrue(result1, "Adding a value should return true when there is space in the array");
        assertTrue(result2, "Adding another value should return true when there is space in the array");

        Method getValueMethod = GenericAnalyser.class.getDeclaredMethod("getValue", int.class);
        String value1 = (String) getValueMethod.invoke(analyser, 0);
        String value2 = (String) getValueMethod.invoke(analyser, 1);

        assertEquals("test1", value1, "The value at index 0 should be the first value added");
        assertEquals("test2", value2, "The value at index 1 should be the second value added");
    }

    @Test
    void testAddValueWhenFull() throws Exception {
        Constructor<?> constructor = GenericAnalyser.class.getDeclaredConstructor(int.class);
        Object analyser = constructor.newInstance(2);

        Method addValueMethod = GenericAnalyser.class.getDeclaredMethod("addValue", Object.class);
        assertTrue((boolean) addValueMethod.invoke(analyser, 1), "Adding a value should return true when there is space in the array");
        assertTrue((boolean) addValueMethod.invoke(analyser, 2), "Adding another value should return true when there is space in the array");
        assertFalse((boolean) addValueMethod.invoke(analyser, 3), "Adding a value should return false when the array is full");
    }

    @Test
    void testGetValue() throws Exception {
        Constructor<?> constructor = GenericAnalyser.class.getDeclaredConstructor(int.class);
        Object analyser = constructor.newInstance(5);

        Method addValueMethod = GenericAnalyser.class.getDeclaredMethod("addValue", Object.class);
        addValueMethod.invoke(analyser, "test1");

        Method getValueMethod = GenericAnalyser.class.getDeclaredMethod("getValue", int.class);
        String value = (String) getValueMethod.invoke(analyser, 0);

        assertEquals("test1", value, "The value at index 0 should match the value that was added");
    }

    @Test
    void testGetValueWithInvalidIndex() throws Exception {
        Constructor<?> constructor = GenericAnalyser.class.getDeclaredConstructor(int.class);
        Object analyser = constructor.newInstance(5);

        Method addValueMethod = GenericAnalyser.class.getDeclaredMethod("addValue", Object.class);
        addValueMethod.invoke(analyser, "test1");

        Method getValueMethod = GenericAnalyser.class.getDeclaredMethod("getValue", int.class);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            try {
                getValueMethod.invoke(analyser, 5);
            } catch (Exception e) {
                throw e.getCause();
            }
        }, "An IndexOutOfBoundsException should be thrown for an invalid index");
    }

    @Test
    void testReverseData() throws Exception {
        Constructor<?> constructor = GenericAnalyser.class.getDeclaredConstructor(int.class);
        Object analyser = constructor.newInstance(5);

        Method addValueMethod = GenericAnalyser.class.getDeclaredMethod("addValue", Object.class);
        addValueMethod.invoke(analyser, "value1");
        addValueMethod.invoke(analyser, "value2");
        addValueMethod.invoke(analyser, "value3");

        Method reverseDataMethod = GenericAnalyser.class.getDeclaredMethod("reverseData");
        reverseDataMethod.invoke(analyser);

        Method getValueMethod = GenericAnalyser.class.getDeclaredMethod("getValue", int.class);
        String value1 = (String) getValueMethod.invoke(analyser, 0);
        String value2 = (String) getValueMethod.invoke(analyser, 1);
        String value3 = (String) getValueMethod.invoke(analyser, 2);

        assertEquals("value3", value1, "The value at index 0 should match the value that was last added before reversing");
        assertEquals("value2", value2, "The value at index 1 should match the value that was in the middle before reversing");
        assertEquals("value1", value3, "The value at index 2 should match the value that was first added before reversing");
    }

    @Test
    void testPrintData() throws Exception {
        Constructor<?> constructor = GenericAnalyser.class.getDeclaredConstructor(int.class);
        Object analyser = constructor.newInstance(3);

        Method addValueMethod = GenericAnalyser.class.getDeclaredMethod("addValue", Object.class);
        addValueMethod.invoke(analyser, "value1");
        addValueMethod.invoke(analyser, "value2");
        addValueMethod.invoke(analyser, "value3");

        // Redirect system out to capture print statements
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        Method printDataMethod = GenericAnalyser.class.getDeclaredMethod("printData");
        printDataMethod.invoke(analyser);

        assertEquals("value1\nvalue2\nvalue3\n", outContent.toString().replaceAll("\r", ""), "The printed data should match the values that were added");

        // Reset the standard output to its original state
        System.setOut(System.out);
    }
}
