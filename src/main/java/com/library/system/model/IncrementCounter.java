package com.library.system.model;

public class IncrementCounter {
    int counter = 0;

    public synchronized void incrementCounter() {
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
