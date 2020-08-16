package com.library.system.service;

import com.library.system.model.Book;
import com.library.system.model.SynchronisedIncrementCounter;

import java.util.ArrayList;
import java.util.List;

/** BookInventorySynchronisedService adds books in a synchronised manner */
public class BookInventorySynchronisedService {

    private int threadPool = 1;

    /** constructor sets the threadPool size */
    public BookInventorySynchronisedService(int threadPool) {
        this.threadPool = threadPool;
    }


    /** adds list of books by calling the synchronised counter and also throws an exception incase
     * the threads are interrupted
     * @param books*/
    public List<Book> addBooks(List<Book> books) throws InterruptedException {
        List<Book> newBooks = new ArrayList<>();

        SynchronisedIncrementCounter rc = new SynchronisedIncrementCounter();

        /** iterator is to create the threads based on the number specified in thread pool
          */
          for (int i = 1; i <= threadPool; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            rc.incrementCounterSync();
                            newBooks.add(new Book(rc.getCounter()));
                        }
                    }).start();
                }

        Thread.sleep(12000);
        return newBooks;
    }
}
