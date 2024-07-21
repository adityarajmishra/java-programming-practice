package com.chatter.platform.models;

public class User {
    private final String username;
    private boolean isLoggedIn;

    public User(String username) {
        this.username = username;
        this.isLoggedIn = false;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
