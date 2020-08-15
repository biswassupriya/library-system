package com.library.system.model;

public class SynchronisedIncrementCounter {
    int counter = 0;

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
