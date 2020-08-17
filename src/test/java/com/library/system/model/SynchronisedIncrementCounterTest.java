package com.library.system.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronisedIncrementCounterTest {

    @Test
    public void testSync() throws Exception {
        SynchronisedIncrementCounter rc = new SynchronisedIncrementCounter();
        final Map<Integer, Integer> testMap = new HashMap<>();
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rc.incrementCounterSync();
                    testMap.put(atomicInteger.getAndIncrement(), new Integer(rc.getCounter()));
                    //    System.out.println("value for " + Thread.currentThread().getName() + " - " + rc.getCounter());
                }
            }).start();
        }
        testMap.entrySet().stream().forEach(entry -> Assert.assertEquals(entry.getKey(), entry.getValue()));
    }

}