package org.skillovilla.level2;

public class NumberUtils {

    // Make this printNumber method generic with upper bound as Number
    // HINT: Add the generic type before the return type of this method, and specify upper bound.
    public static <T extends Number> void printNumber(T number) {
        System.out.println("Number : " + number);
    }

}
