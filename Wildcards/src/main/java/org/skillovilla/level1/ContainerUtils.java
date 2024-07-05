package org.skillovilla.level1;

public class ContainerUtils {

    // Create a method named myContainerData
    // Use an unbounded wildcard to accept a Container of any type
    // Print the data of the container

    public static void myContainerData(Container<?> container) {
        System.out.println("Container data: " + container.getData());
    }


    // You can use this class as a reference
    public static void containerData(Container<?> container) {
        System.out.println("Container data: " + container.getData());
    }

}
