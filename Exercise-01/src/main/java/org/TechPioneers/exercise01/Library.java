package org.TechPioneers.exercise01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Library {


    private Map <String,Integer> books; // <ISBN of the book , Quantity of this book in the library>
    private Map <String , List<String>> loanedBooks; // <UserId , List of loaned books for this user>

    public Library(Map <String,Integer> books) {
        this.books = books;
        this.loanedBooks = new HashMap<>();
    }

    public void loanBook (Book book , User user) {
        String bookISBN = book.getISBN();
        if (!books.containsKey(bookISBN) || books.get(bookISBN) <= 0) {
            System.out.println("We don't have this book in our library!");
            return;
        }

        if (!loanedBooks.containsKey(user.getUserID())) {
            loanedBooks.put(user.getUserID(), new LinkedList<>());
            loanedBooks.get(user.getUserID()).add(bookISBN);
            System.out.println("Book: " + book.getTitle() +  " is loaned from our library by "+ user.getName() +"!");
            return;
        }

        loanedBooks.get(user.getUserID()).add(bookISBN);
        books.put(bookISBN, books.get(bookISBN) - 1);
        System.out.println("Book: " + book.getTitle() +  " is loaned from our library by "+ user.getName() +"!");
    }





    public void receiveBook (Book book , User user) {
        String userId = user.getUserID();
        if (!loanedBooks.containsKey(userId) || !loanedBooks.get(userId).remove(book.getISBN()) ) {
            System.out.println("This book isn't loaned from our library!");
            return;
        }

        System.out.println(user.getName() + " has returned to the library this Book: " + book.getTitle() );
        books.put(book.getISBN(), books.get(book.getISBN()) + 1);
    }


}