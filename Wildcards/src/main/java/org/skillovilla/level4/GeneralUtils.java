package org.skillovilla.level4;

import org.skillovilla.level3.Bucket;

public class GeneralUtils {

    // Create a method named displayData
    // Use an unbounded wildcard to accept a GeneralContainer of any type
    // Print the data of the container

    public static void displayData(GeneralContainer<?> container) {
        System.out.println("Data: " + container.getData());
    }



    // Create a method named checkNumber
    // Use an upper-bounded wildcard to accept a NumberContainer of numbers
    // Print whether the number is positive, negative, or zero

    public static void checkNumber(NumberContainer<? extends Number> container) {
        Number number = container.getData();
        if (number.intValue() > 0) {
            System.out.println("The number is positive");
        } else if (number.intValue() < 0) {
            System.out.println("The number is negative");
        } else {
            System.out.println("The number is zero");
        }
    }


    // Create a method named updateContainer
    // Use a lower-bounded wildcard to accept a ValueContainer of integers or its supertypes
    // Set the container's data to a given integer value
    // Lastly, print the container data using the print statement and getData method

    public static void updateContainer(ValueContainer<? super Integer> container, Integer value) {
        container.setData(value);
        System.out.println("Container data: " + container.getData());
    }




}
