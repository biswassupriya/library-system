package com.library.system.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * model class Library to hold all books and users
 */
public class Library {

    private static List<Book> books = Collections.synchronizedList(new ArrayList<>());
    private static List<User> users = Collections.synchronizedList(new ArrayList<>());

    public static List<Book> getBooks() {
        return books;
    }

    public static void setBook(Book book) {
        books.add(book);
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUser(User user) {
        users.add(user);
    }
}
