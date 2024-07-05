package org.skillovilla.level4;

public class GeneralContainer<T> {
    private T data;

    public GeneralContainer(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
