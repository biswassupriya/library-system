package com.library.system.service;

import com.library.system.model.Book;
import com.library.system.model.Library;
import com.library.system.model.SynchronisedBookIdGenerator;

import java.util.List;

/**
 * BookCreator creates unique id before adding a new book into the library
 * It uses the SynchronisedBookIdGenerator class to get the uniq ids
 */
public class BookCreator implements Runnable {

    private List<Book> books;

    public BookCreator(List<Book> books) {
        this.books = books;
    }

    @Override
    public void run() {
        for (int i = 0; i < books.size(); i++) {
            Library.setBook(new Book(SynchronisedBookIdGenerator.increment(), books.get(0).getBookName(),books.get(0).getUser()));
        }
    }

}