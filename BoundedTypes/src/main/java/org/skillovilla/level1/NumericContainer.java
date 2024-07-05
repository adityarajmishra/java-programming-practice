package org.skillovilla.level1;

public class NumericContainer <T extends Number>{
    private T number;

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }
}
