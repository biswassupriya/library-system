package com.library.system.service;

import com.library.system.model.User;
import org.junit.Assert;
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
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * class UserServiceTest is to test the adding of a user in a non-synchronised manner  - multi-threaded process
 */
public class UserServiceTest {

    UserService userService;
    List<User> users;

    @Before
    public void setUp() {
        users = new ArrayList<>();
    }

    @Test
    public void testConcurrency_withoutSynchronisation_withMultipleThread() {
        List<Integer> expectedUserIds = new ArrayList<>();
        userService = new UserService(10);
        for (int i = 0; i < 100; i++) {
            users.add(new User(i, String.valueOf(i)));
            expectedUserIds.add(i);
        }

        List<User> insertedUsers = userService.addUsers(users);

        List<Integer> userIds = insertedUsers.stream()
                .filter(Objects::nonNull)
                .map(user -> user.getUserId())
                .collect(toList());
        Assert.assertTrue(userIds.containsAll(expectedUserIds));

    }

    private String testName = "";
    private String testeeName = UserService.class.getCanonicalName();
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