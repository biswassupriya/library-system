package com.library.system.model;

import java.util.Arrays;
import java.util.Objects;

/** Model class Book for storing book information*/
public class Book {


    private int isbn;
    private String bookName;
    private String user;
    private final String[] damageDescription = new String[20];

    public Book(int isbn) {
        this.isbn = isbn;
    }

    public Book(int isbn, String bookName, String user) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.user = user;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public String[] getDamageDescription() {
        return damageDescription;
    }

    public boolean isBookAvailable(int isbn) {
        if (this.isbn == isbn) {
            return this.user == null;
        } else
            return false;
    }

    public void getBookDetailsByIsbn(int isbn) {
        if (this.isbn == isbn) {
            if (this.user == null) {
                System.out.println("isbn" + isbn + "BookName" + bookName + "DamageDescription" + Arrays.toString(damageDescription));
            } else {
                System.out.println(isbn + "Book Name" + bookName + "Borrowed by" + this.user + "DamageDescription" + Arrays.toString(damageDescription));
            }
        } else {
            System.out.println("isbn not found");
        }
    }


    public void getBookDetail() {
        if (this.user == null) {
            System.out.println(isbn + "BookName" + bookName + "Damage Description" + Arrays.toString(damageDescription));
        } else {
            System.out.println(isbn + "Book Name" + bookName + "Borrowed by" + this.user + "Damage description: " + Arrays.toString(damageDescription));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

