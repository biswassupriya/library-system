package com.library.system;

import com.library.system.model.Book;
import com.library.system.model.Library;
import com.library.system.service.BookInventorySynchronisedService;

import java.util.ArrayList;
import java.util.List;

/** main class for LibraryApplication */
public class LibraryApplication {

    public static void main(String[] args) throws InterruptedException {
        Library library = new Library();
        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            books.add(new Book(i));
        }

        System.out.println("Adding " + books.size() + " Books to library");
        BookInventorySynchronisedService bookInventoryService = new BookInventorySynchronisedService(10);
        List<Book> insertedBooks = bookInventoryService.addBooks(books);
        library.setBooks(insertedBooks);
        library.getBooks().forEach(book -> System.out.println("Book ISBN: " + book.getIsbn()));
        System.out.println("Added " + insertedBooks.size() + " Books to library");
    }
}
