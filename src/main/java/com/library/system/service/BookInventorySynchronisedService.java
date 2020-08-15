package com.library.system.service;

import com.library.system.model.Book;
import com.library.system.model.SynchronisedIncrementCounter;

import java.util.ArrayList;
import java.util.List;

public class BookInventorySynchronisedService {

    private int threadPool = 1;

    public BookInventorySynchronisedService(int threadPool) {
        this.threadPool = threadPool;
    }

    public List<Book> addBooks(List<Book> books) throws InterruptedException {
        List<Book> newBooks = new ArrayList<>();

        SynchronisedIncrementCounter rc = new SynchronisedIncrementCounter();

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
