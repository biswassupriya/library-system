package com.library.system.service;

import com.google.common.collect.Lists;
import com.library.system.model.User;
import com.library.system.model.Library;

import java.util.List;

/**
 * service class UserService to add Users to the library
 * by calling the non synchronised incrementor
 */
public class UserService {

    private final int threadPool;

    /**
     * constructor initialises the thread pool size
     *
     * @param threadPool number of threads
     */
    public UserService(int threadPool) {
        this.threadPool = threadPool;
    }

    /**
     * method adds a list of Users after generating the unique number and also throws an exception incase
     * the threads are interrupted
     *
     * @param Users list of Users
     * @return list of Users
     */
    public List<User> addUsers(List<User> Users) {
        Thread[] threads = new Thread[threadPool];
        int batchSize = Users.size() / threadPool;
        List<List<User>> batches = Lists.partition(Users, batchSize);

        for (int i = 0; i < threadPool; i++) {
            threads[i] = new Thread(new UserCreator(batches.get(i)));
            threads[i].start();
        }

        for (int i = 0; i < threadPool; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return Library.getUsers();
    }
}
