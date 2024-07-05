package org.skillovilla.genericclassesandmethods.level1;

// Given generic class example
public class Container<T> {

    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}