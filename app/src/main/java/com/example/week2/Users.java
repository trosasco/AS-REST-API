package com.example.week2;

public class Users {

    private int mUserId;
    private String mUsername;
    private String mPassword;

    public Users(int mUserId, String mUsername, String mPassword) {
        this.mUserId = mUserId;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
