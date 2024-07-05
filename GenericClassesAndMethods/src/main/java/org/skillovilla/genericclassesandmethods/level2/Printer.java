package org.skillovilla.genericclassesandmethods.level2;

public class Printer<S> {

    public void printMessage(S message) {
        System.out.println("The message is : " + message);
    }

}
