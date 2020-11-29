package com.library.system.service;

import com.library.system.model.Book;
import com.library.system.model.SynchronisedBookIdGenerator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class BookServiceTest {

    BookService bookService;

    @Test
    public void testConcurrency_withMultipleThread() throws InterruptedException {
        SynchronisedBookIdGenerator.resetCounter();
        List<Integer> expectedBookIds = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        bookService = new BookService(10);
        for (int i = 0; i < 100; i++) {
            books.add(new Book(i));
            expectedBookIds.add(i);
        }

        List<Book> insertedBooks = bookService.addBooks(books);

        List<Integer> isbns = insertedBooks.stream()
                .filter(Objects::nonNull)
                .map(Book::getIsbn)
                .collect(toList());
        Assert.assertTrue(isbns.containsAll(expectedBookIds));

    }


    private String testName = "";
    private String testeeName = BookService.class.getCanonicalName();
    private boolean failed;

    @Rule
    public TestRule afterWithFailedInformation = RuleChain
            .outerRule(new ExternalResource() {
                @Override
                protected void after() {
                    System.out.println(testeeName + "-" + testName + "-" + (failed ? "failed" : "passed"));
                }
            })
            .around(new TestWatcher() {
                @Override
                protected void finished(Description description) {
                    testName = description.getDisplayName();
                }

                @Override
                protected void failed(Throwable e, Description description) {
                    failed = true;
                }
            });
}