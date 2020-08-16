package com.library.system.model;

/**model class Incrementer is to count the isbn unique book number */
public class Incrementer {
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

    public void incrementCounter() {
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