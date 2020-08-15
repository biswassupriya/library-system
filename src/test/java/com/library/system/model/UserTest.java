package com.library.system.model;

import com.library.system.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.List;

public class UserTest {

    User testee;

    @Before
    public void setUp() throws Exception {
        testee = new User();
    }

    @Test
    public void testAppendMessage_givenArrayIsEmpty_whenAppendMessageIsCalled_thenReturnTrue() {

        final boolean result = testee.appendMessage("supriya");

        Assert.assertTrue(result == true);
        List<String> messages = testee.getMessages();
        Assert.assertTrue(messages.get(0) == "supriya");
    }

    @Test
    public void testAppendMessage_givenTheArrayHas1Element_whenAppendMessage_thenReturnTrue_andArrayHas2Elements() {
        testee.appendMessage("Supriya");

        final boolean message = testee.appendMessage("snigdha");

        Assert.assertTrue(message == true);
        List<String> messages = testee.getMessages();
        Assert.assertTrue(messages.get(1) == "snigdha");
    }

    @Test
    public void givenAValidUserId_havingMessages_returnAllMessagesForTheUser() {
        testee.setUserId(1);
        testee.appendMessage("supriya");
        testee.appendMessage("snigdha");
        String expectedMessage = "User Id: 1 Messages: supriya,snigdha";

        String result = testee.getAllMessagesByUserId(1);

        Assert.assertEquals(expectedMessage, result);
    }

    @Test
    public void givenInvalidUserId_returnsUserIdNotfound() {
        String expectedMessage = "User Id: 6 not found";

        final String result = testee.getAllMessagesByUserId(6);

        Assert.assertEquals(expectedMessage, result);
    }

    @Test
    public void givenAValidUserId_withNoMessages_returnsNoMessagesFoundForTheUser() {
        testee.setUserId(1);
        String expected = "User Id: 1 Messages: No Messages Found";

        final String message = testee.getAllMessagesByUserId(1);
        Assert.assertEquals(expected, message);
    }

    private String testName = "";
    private boolean failed;

    @Rule
    public TestRule afterWithFailedInformation = RuleChain
            .outerRule(new ExternalResource() {
                @Override
                protected void after() {

                    System.out.println("Test " + testName + " " + (failed ? "failed" : "finished") + ".");
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