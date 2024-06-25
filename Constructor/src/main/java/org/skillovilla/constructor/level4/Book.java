package org.skillovilla.constructor.level4;

public class Book {
    String title;
    String author;

    // Create a parameterized constructor here that takes title and author as parameter
    // It should print Title and author in the format: Title: "title", Author: "author"

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        System.out.println("Title: " + title + ", Author: " + author);
    }


}
