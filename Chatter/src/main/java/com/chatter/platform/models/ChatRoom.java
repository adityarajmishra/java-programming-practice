package com.chatter.platform.models;

import java.util.HashSet;
import java.util.Set;

public class ChatRoom {
    private final String name;
    private final Set<String> users;

    public ChatRoom(String name) {
        this.name = name;
        this.users = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public boolean addUser(String username) {
        return users.add(username);
    }

    public boolean hasUser(String username) {
        return users.contains(username);
    }

    public void removeUser(String username) {
        users.remove(username);
    }
}
