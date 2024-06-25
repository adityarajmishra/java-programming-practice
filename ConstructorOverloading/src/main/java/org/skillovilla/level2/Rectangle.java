package org.skillovilla.level2;

public class Rectangle {
    int width;
    int height;

    /*
     Create a default constructor that initializes width and height to 0
     Create a parameterized constructor that initializes width and height to the given values
     Create another parameterized constructor that initializes width and height to the same given value (square)
    */

    public Rectangle() {
        this.width = 0;
        this.height = 0;
    }
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(int value) {
        this.width = value;
        this.height = value;
    }
}