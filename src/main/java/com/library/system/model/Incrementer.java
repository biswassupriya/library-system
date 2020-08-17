package com.library.system.model;

/**class generates the isbn unique book number */
public class Incrementer {
    int counter = 0;

    /** unsynchronised increment of the counter */
    public void incrementCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }


}