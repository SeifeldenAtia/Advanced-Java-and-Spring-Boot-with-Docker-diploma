package org.TechPioneers.exercise01;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Effective Java", "978-0134685991");
        Book book2 = new Book("Java: The Complete Reference", "978-1259589310");

        User user1 = new User("U1001", "Sharafuldin");
        User user2 = new User("U1002", "Kheiruldin");

        Library library = new Library(createBooks());

        library.receiveBook(book1 , user1);

        library.loanBook(book1 , user1);
        library.loanBook(book2 , user1);
        library.loanBook(book2 , user2);

        library.receiveBook(book2 , user1);
        library.loanBook(book2 , user2);
    }

    public static Map<String, Integer> createBooks () {
        Book book1 = new Book("Effective Java", "978-0134685991");
        Book book2 = new Book("Java: The Complete Reference", "978-1259589310");
        Book book3 = new Book("Head First Java", "978-0596009205");
        Book book4 = new Book("Java Concurrency in Practice", "978-0321349606");
        Book book5 = new Book("Java: A Beginner's Guide", "978-0071809252");

        Map<String, Integer> books = new HashMap<>();
        books.put(book1.getISBN(), 5);
        books.put(book2.getISBN(), 1);
        books.put(book3.getISBN(), 5);
        books.put(book4.getISBN(), 5);
        books.put(book5.getISBN(), 5);
        return books;
    }

}
