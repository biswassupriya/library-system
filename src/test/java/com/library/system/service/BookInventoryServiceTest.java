package com.library.system.service;

import com.library.system.model.Book;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

/** class BookInventoryServiceTest is to test the adding of a book in a non-synchronised manner of a single
 * and multi-threaded process  */
public class BookInventoryServiceTest {

    BookInventoryService bookInventoryService;
    List<Book> books;

    @Before
    public void setUp() {
        books = new ArrayList<>();
    }

    @Test
    public void testConcurrency_withoutSynchronisation_withMultipleThread_passes() throws InterruptedException {
        List<Integer> isbns = new ArrayList();
        bookInventoryService = new BookInventoryService(10);
        for (int i = 1; i <= 10; i++) {
            books.add(new Book(i));
            isbns.add(i);
        }


        List<Book> insertedBooks = bookInventoryService.addBooks(books);
        assertTrue(insertedBooks.stream()
                .filter(x -> x != null)
                .map(book -> new Integer(book.getIsbn()))
                .collect(toList()).containsAll(isbns));
    }

    @Test
    public void testConcurrency_withoutSynchronisation_withSingleThread_passes() throws InterruptedException {
        List<Integer> isbns = new ArrayList();
        bookInventoryService = new BookInventoryService(1);
        books.add(new Book(1));
        isbns.add(1);

        List<Book> insertedBooks = bookInventoryService.addBooks(books);
        assertTrue(insertedBooks.stream()
                .filter(x -> x != null)
                .map(book -> new Integer(book.getIsbn()))
                .collect(toList()).containsAll(isbns));
    }

    private String testName = "";
    private boolean failed;

    @Rule
    public TestRule afterWithFailedInformation = RuleChain
            .outerRule(new ExternalResource() {
                @Override
                protected void after() {

                    System.out.println("Test-" + testName + "-" + (failed ? "failed" : "passed"));
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