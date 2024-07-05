package org.skillovilla.genericclassesandmethods.level3;

public class Printer<S> {

    public void printMessage(S message) {
        System.out.println("The message is : " + message);
    }

    public <E>void printMessageTwo(E message) {
        System.out.println("The message is : " + message);
    }

}
