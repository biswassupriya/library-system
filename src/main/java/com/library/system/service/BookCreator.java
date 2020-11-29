package com.library.system.service;

import com.library.system.model.Book;
import com.library.system.model.Library;
import com.library.system.model.SynchronisedBookIdGenerator;

import java.util.List;

public class BookCreator implements Runnable {

    private List<Book> books;

    public BookCreator(List<Book> books) {
        this.books = books;
    }

    @Override
    public void run() {
/*        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e. printStackTrace ();
        }*/
        for (int i = 0; i < books.size(); i++) {
            Library.setBook(new Book(SynchronisedBookIdGenerator.increment(), books.get(0).getBookName(),books.get(0).getUser()));
        }
    }

}