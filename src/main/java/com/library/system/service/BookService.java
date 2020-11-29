package com.library.system.service;

import com.google.common.collect.Lists;
import com.library.system.model.Book;
import com.library.system.model.Library;

import java.util.List;

/**
 * BookService adds books in a synchronised manner
 */
public class BookService {

    private final int threadPool;

    /**
     * constructor initialises the thread pool size
     *
     * @param threadPool number of threads
     */
    public BookService(int threadPool) {
        this.threadPool = threadPool;
    }


    /**
     * adds list of books by calling the synchronised counter and also throws an exception incase
     * the threads are interrupted
     *
     * @param books list of Books
     * @return list of Books
     */
    public List<Book> addBooks(List<Book> books) {
        Thread[] threads = new Thread[threadPool];
        int batchSize = books.size() / threadPool;
        List<List<Book>> batches = Lists.partition(books, batchSize);

        for (int i = 0; i < threadPool; i++) {
            threads[i] = new Thread(new BookCreator(batches.get(i)));
            threads[i].start();
        }

        for (int i = 0; i < threadPool; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return Library.getBooks();
    }
}
