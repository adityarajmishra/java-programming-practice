package org.skillovilla.level4;

public class ValueContainer<T> {
    private T data;

    public ValueContainer(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
