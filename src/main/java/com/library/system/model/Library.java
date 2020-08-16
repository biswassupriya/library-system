package com.library.system.model;

import java.util.List;
/** model class Library to hold all books and users */
public class Library {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
