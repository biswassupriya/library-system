package com.library.system.service;

import com.library.system.model.*;

import java.util.List;

public class UserCreator implements Runnable {

    private List<User> users;

    public UserCreator(List<User> users) {
        this.users = users;
    }

    @Override
    public void run() {
/*        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e. printStackTrace ();
        }*/
        for (int i = 0; i < users.size(); i++) {
            Library.setUser(new User(UserIdGenerator.increment(), users.get(0).getUserName()));
        }
    }

}