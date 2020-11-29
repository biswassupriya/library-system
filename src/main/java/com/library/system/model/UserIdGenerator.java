package com.library.system.model;

/**
 * class generates the id
 */
public class UserIdGenerator {
    private static int counter = 0;

    /**
     * un-synchronised increment of the counter
     */
    public static int increment() {
/*        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return counter++;
    }

/*    public static int getCounter() {
        return counter;
    }*/

    public static void resetCounter() {
        counter = 0;
    }


}