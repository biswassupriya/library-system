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

/** Test class for model user */
public class UserTest {

    User testee;

    @Before
    public void setUp() throws Exception {
        testee = new User();
    }

    /** Method test appendMessage returns true and adds the message in the array list */
    @Test
    public void testAppendMessage_givenArrayIsEmpty_whenAppendMessageIsCalled_thenReturnTrue() {

        final boolean result = testee.appendMessage("supriya");

        Assert.assertTrue(result == true);
        List<String> messages = testee.getMessages();
        Assert.assertTrue(messages.get(0) == "supriya");
    }

    /**Method testAppendMessage adds a new elements to the existing array list
     * @arg string
     * @returns boolean
     * @verifies the second elements stored in the array list */
    @Test
    public void testAppendMessage_givenTheArrayHas1Element_whenAppendMessage_thenReturnTrue_andArrayHas2Elements() {
        testee.appendMessage("Supriya");

        final boolean message = testee.appendMessage("snigdha");

        Assert.assertTrue(message == true);
        List<String> messages = testee.getMessages();
        Assert.assertTrue(messages.get(1) == "snigdha");
    }

    /** Test method getAllMessagesByUserId to get all the messages by the user id
     * @arg string
     * @verifies String variables */
    @Test
    public void givenAValidUserId_havingMessages_returnAllMessagesForTheUser() {
        testee.setUserId(1);
        testee.appendMessage("supriya");
        testee.appendMessage("snigdha");
        String expectedMessage = "User Id: 1 Messages: supriya,snigdha";

        String result = testee.getAllMessagesByUserId(1);

        Assert.assertEquals(expectedMessage, result);
    }

    /** test method getAllMessagesByUserId to check if the given user id is valid
     * @arg string(userid)
     * @returns a string message wheather userid id avaiable
     */
    @Test
    public void givenInvalidUserId_returnsUserIdNotfound() {
        String expectedMessage = "User Id: 6 not found";

        final String result = testee.getAllMessagesByUserId(6);

        Assert.assertEquals(expectedMessage, result);
    }

    /** test method getAllMessagesByUserId to get all messages stored in the given userid
     *@arg string userid
     * @returns a string message if there are any messages avbailable or not */
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