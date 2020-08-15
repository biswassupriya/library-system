package com.library.system.service;

import com.library.system.model.Book;
import com.library.system.model.Incrementer;

import java.util.ArrayList;
import java.util.List;

public class BookInventoryService {

    private int threadPool = 1;

    public BookInventoryService(int threadPool) {
        this.threadPool = threadPool;
    }

    public List<Book> addBooks(List<Book> books) throws InterruptedException {
        Incrementer rc = new Incrementer();
        List<Book> newBooks = new ArrayList<>();

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
