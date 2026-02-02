# Assignment 1 - Library Book Loan Management System

## Problem Description:

You are developing a system for a library to manage book loans. The system should support the following operations:

- **Add a New Book Loan**: When a book is loaned out, its ID (ISBN) is added to the system.
- **Return a Book**: When a book is returned, its ID is removed from the system.
- **Track Book Loans**: The system should keep track of all loaned books by user, and handle book returns efficiently.

## Solution Overview:

This solution is implemented as a **Maven** project in Java. It leverages collections to handle the operations of adding, removing, and tracking book loans in an efficient manner.

### Key Features of the Implementation:
1. **Loan Book**: Adds a book’s ISBN to the user’s loan list if the book is available and not already loaned out.
2. **Return Book**: Removes a book’s ISBN from the user’s loan list when it is returned, and updates the available quantity of the book in the library.
3. **Tracking Book Loans**: Keeps track of the loaned books by user, ensuring that the books are loaned and returned in the right order.

### Design:
- **Library Class**: Manages books in the library and tracks loaned books. It uses:
    - A `Map<String, Integer>` to store books and their quantities.
    - A `Map<String, List<String>>` to track the loaned books by user ID.

- **Book Class**: Represents a book with a title and ISBN.

- **User Class**: Represents a user with a user ID and name.

### Maven Project Structure:
This is a Maven-based project. The **pom.xml** file includes necessary dependencies for the project.