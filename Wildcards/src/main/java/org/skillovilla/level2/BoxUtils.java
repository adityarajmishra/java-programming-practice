package org.skillovilla.level2;

public class BoxUtils {

    // Create a method named printBoxInfo
    // Use an upper-bounded wildcard to accept a Box of numbers
    // Print whether the number is positive, negative, or zero

    public static void printBoxInfo(Box<? extends Number> box) {
        Number number = box.getData();
        if (number.intValue() > 0) {
            System.out.println("The number is positive.");
        } else if (number.intValue() < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }
    }

    // Reference method
    public static void boxInfo(Box<? extends Number> box) {
        Number number = box.getData();
        if (number.intValue() > 0) {
            System.out.println("The number is positive.");
        } else if (number.intValue() < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }
    }

}
