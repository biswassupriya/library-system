package com.library.system.service;

import com.library.system.model.Library;
import com.library.system.model.User;
import com.library.system.model.UserIdGenerator;

import java.util.List;

/**
 * UserCreator creates unique id before adding a new user into the library
 * It uses the UserIdGenerator class to get the uniq ids
 */

public class UserCreator implements Runnable {

    private List<User> users;

    public UserCreator(List<User> users) {
        this.users = users;
    }

    @Override
    public void run() {
        for (int i = 0; i < users.size(); i++) {
            Library.setUser(new User(UserIdGenerator.increment(), users.get(0).getUserName()));
        }
    }

}