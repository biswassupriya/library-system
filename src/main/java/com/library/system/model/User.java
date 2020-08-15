package com.library.system.model;

import java.util.ArrayList;
import java.util.List;

public class User {

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

  //  public int getBooksBorrowedCount(int userId) {
     //   if (this.userId == userId) {
            // return "UserId: Has borrowed books:".format(String.valueOf(userId), bookBorrowed.length;
       //} else {
          //  "User Id not found".format("", userId);
        //}

  //  }

}
