package com.chatter.platform.services;

import com.chatter.platform.models.User;
import com.chatter.platform.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public String registerUser(String username) {
        if (users.containsKey(username)) {
            return Constants.USERNAME_ALREADY_EXISTS;
        }

        users.put(username, new User(username));
        return Constants.SUCCESS;
    }

    public String loginUser(String username) {
        User user = users.get(username);
        if (user == null) {
            return Constants.USERNAME_NOT_FOUND;
        }
        if (user.isLoggedIn()) {
            return Constants.USERNAME_ALREADY_ONLINE;
        }
        user.setLoggedIn(true);
        return Constants.SUCCESS;
    }

    public String logoutUser(String username) {
        User user = users.get(username);
        if (user == null) {
            return Constants.USERNAME_NOT_FOUND;
        }
        if (!user.isLoggedIn()) {
            return Constants.USERNAME_NOT_ONLINE;
        }
        user.setLoggedIn(false);
        return Constants.SUCCESS;
    }

    public boolean isUserRegistered(String username) {
        return users.containsKey(username);
    }

    public boolean isUserLoggedIn(String username) {
        User user = users.get(username);
        return user != null && user.isLoggedIn();
    }

    public String getUserDetail(String username, ChatRoomService chatRoomService) {
        User user = users.get(username);
        if (user == null) {
            return Constants.USERNAME_NOT_FOUND;
        }
        String roomName = chatRoomService.getUserRoom(username);
        return String.format("Username: %s\nLoggedIn: %b\nChat Room: %s",
                user.getUsername(), user.isLoggedIn(), roomName == null ? "null" : roomName);
    }

    public int getUserCount() {
        return users.size();
    }
}
