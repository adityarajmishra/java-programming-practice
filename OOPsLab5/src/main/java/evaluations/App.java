/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package evaluations;

import evaluations.level1.GenericContainer;

public class App {
    public static void main(String[] args) {
        GenericContainer<String> container = new GenericContainer<>(5);
        container.addValue("goli");
        container.addValue("boli");
        container.addValue("roli");
        container.addValue("foli");
        container.addValue("poli");
        container.printContainer();
    }
}