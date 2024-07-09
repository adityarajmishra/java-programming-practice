package evaluations.level3;

import java.util.List;

public class PracticeMethodLevelGeneric {
    // Method with a generic parameter
    public <T> void printArrayPractice(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    // Method with a wildcard parameter
    public void printListPractice(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    // Method with an upper-bounded wildcard parameter
    public void printNumbersPractice(List<? extends Integer> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    // Method  with a lower-bounded wildcard parameter
    public void addNumbersPractice(List<? super Number> list, List<? extends Number> elementsToAdd) {
        for (Number element : elementsToAdd) {
            list.add(element);
        }
    }

    // Method with a generic return type
    public <T> T returnFirstElementPractice(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    // Method with multiple generic parameters
    public <K, V> void printKeyValuePractice(K key, V value) {
        System.out.println("Key: " + key + ", Value: " + value);
    }

    // Method with a bounded type parameter
    public <T extends Comparable<T>> T findMaxPractice(T[]  array) {
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
    public <T extends Number & Comparable<T>> T findMaxNumberPractice(T[] array) {
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
