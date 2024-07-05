package org.skillovilla.genericclassesandmethods.level1;

public class Box <T> {


    T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
