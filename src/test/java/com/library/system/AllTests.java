package com.library.system;

import com.library.system.service.UserServiceTest;
import com.library.system.service.BookServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({UserServiceTest.class, BookServiceTest.class})
public class AllTests {

}