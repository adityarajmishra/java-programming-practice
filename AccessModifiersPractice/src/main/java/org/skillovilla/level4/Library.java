package org.skillovilla.level4;

public class Library {
    private int books;
    protected void addBook(int count) {
        this.books += count;
    }

    protected void removeBook(int count) {
        this.books -= count;
    }
    public int getBooks() {
        return books;
    }
}
