package evaluations.level3;

import java.util.List;

public class ReferenceMethodLevelGeneric {

    // Method with a generic parameter
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    // Method with a wildcard parameter
    public void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    // Method with an upper-bounded wildcard parameter
    public void printNumbers(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    // Method  with a lower-bounded wildcard parameter
    public void addNumbers(List<? super Number> list, List<? extends Number> elementsToAdd) {
        for (Number element : elementsToAdd) {
            list.add(element);
        }
    }

    // Method with a generic return type
    public <T> T returnFirstElement(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    // Method with multiple generic parameters
    public <K, V> void printKeyValue(K key, V value) {
        System.out.println("Key: " + key + ", Value: " + value);
    }

    // Method with a bounded type parameter
    public <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    // Method with a generic parameter with multiple bounds
    public <T extends Number & Comparable<T>> T findMaxNumber(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }
}
