package com.library.system.service;

import com.library.system.model.Book;
import com.library.system.model.Incrementer;

import java.util.ArrayList;
import java.util.List;

/**  service class BookInventoryService to add books to the library by calling the non synchronised incrementor*/
public class BookInventoryService {

    private int threadPool = 1;

/** constructor initialises the thread pool size*/
    public BookInventoryService(int threadPool) {
        this.threadPool = threadPool;
    }

    /** method adds a list of books after generating the unique number and also throws an exception incase
     * the threads are interrupted
     * @param books*/
    public List<Book> addBooks(List<Book> books) throws InterruptedException {
        Incrementer rc = new Incrementer();
        List<Book> newBooks = new ArrayList<>();

        /** iterator is to initialize the thread based on the number specified in thread pool
         * method name run
         * @ return newbooks*/
        for (int i = 1; i <= threadPool; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rc.incrementCounter();
                    newBooks.add(new Book(rc.getCounter()));
                }
            }).start();
        }

        Thread.sleep(12000);
        return newBooks;
    }
}
