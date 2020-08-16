package com.library.system.model;

/**model class Incrementer is to count the isbn unique book number */
public class Incrementer {
    int counter = 0;

    public void incrementCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }


}