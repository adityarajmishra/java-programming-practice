package org.skillovilla.level3;

public class BucketUtils {

    // Create a method named setBucketData
    // Use a lower-bounded wildcard to accept a Bucket of integers or its supertypes
    // Set the bucket's data to a given integer value
    // Lastly, print the bucket data using the print statement and getData method

    public static void setBucketData(Bucket<? super Integer> box, Integer value) {
        box.setData(value);
        System.out.println("Bucket data: " + box.getData());
    }


    // Reference method
    public static void addToBucket(Bucket<? super Double> box, Double value) {
        box.setData(value);
    }

}
