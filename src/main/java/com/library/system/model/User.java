package com.library.system.model;

import java.util.ArrayList;
import java.util.List;

/** model class  hold all the user information */
public class User {

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<String> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    private int userId;
    private String userName;
    private List<String> booksBorrowed = new ArrayList<>();
    private List<String> messages = new ArrayList<>();


    public boolean appendMessage(String message) {
        messages.add(message);
        return true;
    }

    public String getAllMessagesByUserId(int userId) {
        if (this.userId == userId) {
           String msg = this.messages.size() == 0 ? "No Messages Found" : String.join(",", messages);
           return "User Id: " + userId + " Messages: " + msg;
        } else {
            return "User Id: " + userId + " not found";
        }
    }

    public String getAllBooksByUserId(int userId) {
        if (this.userId == userId) {
            String msg = this.messages.size() == 0 ? "No Messages Found" : String.join(",", messages);
            return "User Id: " + userId + " Messages: " + msg;
        } else {
            return "User Id: " + userId + " not found";
        }
    }

}
