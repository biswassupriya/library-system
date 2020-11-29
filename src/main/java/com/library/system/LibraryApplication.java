package com.library.system;

import com.library.system.model.Book;
import com.library.system.model.Library;
import com.library.system.model.User;
import com.library.system.service.BookService;
import com.library.system.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** main class for LibraryApplication */
public class LibraryApplication {

    public static void main(String[] args) throws InterruptedException {
        List<Book> books = new ArrayList<>();
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            books.add(new Book(i));
            users.add(new User(i, String.valueOf(i)));
        }

        System.out.println("Adding " + books.size() + " Books to library");
        BookService bookService = new BookService(2);
        List<Book> insertedBooks = bookService.addBooks(books);
        insertedBooks.stream().filter(Objects::nonNull).forEach(book -> System.out.println("Book ISBN: " + book.getIsbn()));
        System.out.println("Added " + Library.getBooks().size() + " Books to library");

        System.out.println("Adding " + users.size() + " Users to library");
        UserService userService = new UserService(2);
        List<User> insertedUsers  = userService.addUsers(users);
        insertedUsers.stream().filter(Objects::nonNull).forEach(user -> System.out.println("User Id: " + user.getUserId()));
        System.out.println("Added " + Library.getUsers().size() + " Users to library");
    }
}
