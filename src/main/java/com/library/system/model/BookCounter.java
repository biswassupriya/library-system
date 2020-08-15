package com.library.system.model;

public class BookCounter {
    int counter = 0;
    //private static volatile int counter = 0;

    public void incrementCounter() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
