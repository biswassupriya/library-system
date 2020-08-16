package com.library.system.model;

/**SynchronisedIncrementCounter generates a unique number in a synchronised manner */
public class SynchronisedIncrementCounter {
    int counter = 0;

    /** Synchronised Method increments the counter */
    public synchronized void incrementCounterSync() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
