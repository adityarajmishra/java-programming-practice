package evaluations.level3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PracticeMethodLevelGenericTest {

    @Test
    void testPrintArrayPractice() throws Exception {
        Method method = PracticeMethodLevelGeneric.class.getDeclaredMethod("printArrayPractice", Object[].class);
        assertNotNull(method, "Method printArrayPractice should be present and accept a generic array");

        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"a", "b", "c"};

        assertDoesNotThrow(() -> method.invoke(new PracticeMethodLevelGeneric(), (Object) intArray), "Method should work with an array of any type");
        assertDoesNotThrow(() -> method.invoke(new PracticeMethodLevelGeneric(), (Object) strArray), "Method should work with an array of any type");
    }

    @Test
    void testPrintListPractice() throws Exception {
        Method method = PracticeMethodLevelGeneric.class.getDeclaredMethod("printListPractice", List.class);
        assertNotNull(method, "Method printListPractice should be present and accept a wildcard list");

        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<String> strList = Arrays.asList("a", "b", "c");

        assertDoesNotThrow(() -> method.invoke(new PracticeMethodLevelGeneric(), intList), "Method should work with a list of any type");
        assertDoesNotThrow(() -> method.invoke(new PracticeMethodLevelGeneric(), strList), "Method should work with a list of any type");
    }

    @Test
    void testPrintNumbersPractice() throws Exception {
        Method method = PracticeMethodLevelGeneric.class.getDeclaredMethod("printNumbersPractice", List.class);
        assertNotNull(method, "Method printNumbersPractice should be present and accept an upper-bounded wildcard list");

        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

        assertDoesNotThrow(() -> method.invoke(new PracticeMethodLevelGeneric(), intList), "Method should work with a list of numbers");
        assertDoesNotThrow(() -> method.invoke(new PracticeMethodLevelGeneric(), doubleList), "Method should work with a list of numbers");
    }


    @Test
    void testAddNumbersPractice() throws Exception {
        // Initial method signature: public void addNumbers(List<Integer> list, List<Integer> elementsToAdd)
        // Transformed to: public void addNumbers(List<? super Number> list, List<? extends Number> elementsToAdd)

        Method method = PracticeMethodLevelGeneric.class.getDeclaredMethod("addNumbersPractice", List.class, List.class);
        assertNotNull(method, "Method addNumbersPractice should be present and accept a lower-bounded wildcard list and an upper-bounded wildcard list");

        List<Number> targetList = new ArrayList<>();
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

        // Test with Integer list
        assertDoesNotThrow(() -> method.invoke(new PracticeMethodLevelGeneric(), targetList, intList), "Method should handle adding elements to the target list without throwing exceptions");
        assertEquals(3, targetList.size(), "The target list should contain the correct number of elements after adding");
        assertTrue(targetList.containsAll(intList), "The target list should contain all elements from the source list");

        // Clear the list and test with Double list
        targetList.clear();
        assertDoesNotThrow(() -> method.invoke(new PracticeMethodLevelGeneric(), targetList, doubleList), "Method should handle adding elements to the target list without throwing exceptions");
        assertEquals(3, targetList.size(), "The target list should contain the correct number of elements after adding");
        assertTrue(targetList.containsAll(doubleList), "The target list should contain all elements from the source list");
    }

    @Test
    void testReturnFirstElementPractice() throws Exception {
        Method method = PracticeMethodLevelGeneric.class.getDeclaredMethod("returnFirstElementPractice", List.class);
        assertNotNull(method, "Method returnFirstElementPractice should be present and return a generic type");

        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<String> strList = Arrays.asList("a", "b", "c");

        Integer firstInt = (Integer) method.invoke(new PracticeMethodLevelGeneric(), intList);
        String firstStr = (String) method.invoke(new PracticeMethodLevelGeneric(), strList);

        assertEquals(1, firstInt, "The first element should match the first element in the list");
        assertEquals("a", firstStr, "The first element should match the first element in the list");
    }

    @Test
    void testPrintKeyValuePractice() throws Exception {
        Method method = PracticeMethodLevelGeneric.class.getDeclaredMethod("printKeyValuePractice", Object.class, Object.class);
        assertNotNull(method, "Method printKeyValuePractice should be present and accept two generic parameters");

        assertDoesNotThrow(() -> method.invoke(new PracticeMethodLevelGeneric(), 1, "one"), "Method should work with key-value pairs of any type");
        assertDoesNotThrow(() -> method.invoke(new PracticeMethodLevelGeneric(), "key", 123), "Method should work with key-value pairs of any type");
    }

    @Test
    void testFindMaxPractice() throws Exception {
        Method method = PracticeMethodLevelGeneric.class.getDeclaredMethod("findMaxPractice", Comparable[].class);
        assertNotNull(method, "Method findMaxPractice should be present and return the maximum element of a type parameter with a single bound");

        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"apple", "banana", "cherry"};

        Integer maxInt = (Integer) method.invoke(new PracticeMethodLevelGeneric(), (Object) intArray);
        String maxStr = (String) method.invoke(new PracticeMethodLevelGeneric(), (Object) strArray);

        assertEquals(3, maxInt, "The maximum element should be the largest element in the array");
        assertEquals("cherry", maxStr, "The maximum element should be the largest element in the array");
    }

    @Test
    void testFindMaxNumberPractice() throws Exception {
        Method method = PracticeMethodLevelGeneric.class.getDeclaredMethod("findMaxNumberPractice", Number[].class);
        assertNotNull(method, "Method findMaxNumberPractice should be present and return the maximum element of a type parameter with multiple bounds");

        Integer[] intArray = {1, 2, 3};
        Double[] doubleArray = {1.1, 2.2, 3.3};

        Integer maxInt = (Integer) method.invoke(new PracticeMethodLevelGeneric(), (Object) intArray);
        Double maxDouble = (Double) method.invoke(new PracticeMethodLevelGeneric(), (Object) doubleArray);

        assertEquals(3, maxInt, "The maximum element should be the largest element in the array");
        assertEquals(3.3, maxDouble, 0.001, "The maximum element should be the largest element in the array");
    }
}
