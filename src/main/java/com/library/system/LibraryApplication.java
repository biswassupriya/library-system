package com.library.system;

import com.library.system.model.Book;
import com.library.system.model.Library;
import com.library.system.service.BookInventorySynchronisedService;

import java.util.ArrayList;
import java.util.List;

public class LibraryApplication {

    public static void main(String[] args) throws InterruptedException {
        Library library = new Library();
        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            books.add(new Book(i));
        }

        BookInventorySynchronisedService bookInventoryService = new BookInventorySynchronisedService(10);
        List<Book> insertedBooks = bookInventoryService.addBooks(books);
        library.setBooks(insertedBooks);
        library.getBooks().forEach(book -> System.out.println("Books in Library " + book.getIsbn()));
    }

}
