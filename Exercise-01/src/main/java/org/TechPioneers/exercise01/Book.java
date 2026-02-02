package org.TechPioneers.exercise01;

public class Book {

    private String title;
    private String ISBN;

    public Book(String title, String ISBN) {
        this.title = title;
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }
}