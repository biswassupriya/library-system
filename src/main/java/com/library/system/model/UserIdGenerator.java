package com.library.system.model;

/**
 * class generates the id for Users
 */
public class UserIdGenerator {
    private static int counter = 0;

    /**
     * un-synchronised increment of the counter
     * @return Integer value after incrementing the counter
     */
    public static int increment() {
        return counter++;
    }

    public static void resetCounter() {
        counter = 0;
    }

}