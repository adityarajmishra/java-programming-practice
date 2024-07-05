package org.skillovilla.level4;

public class NumberContainer<T extends Number> {
    private T data;

    public NumberContainer(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
