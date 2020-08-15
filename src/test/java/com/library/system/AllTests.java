package com.library.system;

import com.library.system.model.UserTest;
import com.library.system.service.BookInventoryServiceTest;
import com.library.system.service.BookInventorySynchronisedServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserTest.class, BookInventoryServiceTest.class, BookInventorySynchronisedServiceTest.class })
public class AllTests {

}