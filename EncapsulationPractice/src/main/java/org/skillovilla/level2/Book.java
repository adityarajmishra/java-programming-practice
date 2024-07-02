package org.skillovilla.level2;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private double price;

    public Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookDetails() {
        return "ISBN: " + isbn + ", " + "Title: " + title + ", " + "Author: " + author + ", " + "Price: " + price;
    }
    public double applyDiscount(double discountPercentage) {
        price = price - (price * discountPercentage / 100);
        return price;
    }
}
