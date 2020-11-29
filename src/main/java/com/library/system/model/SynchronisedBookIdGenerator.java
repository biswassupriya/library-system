package com.library.system.model;

/**SynchronisedBookIdGenerator generates id in a synchronised manner */
public class SynchronisedBookIdGenerator {
    private static int counter = 0;

    /** Synchronised Method increments the counter */
    public static synchronized int increment() {
        return counter++;
    }

    public static void resetCounter() {
        counter = 0;
    }
}
