package com.chatter.platform.services;

import com.chatter.platform.models.ChatRoom;
import com.chatter.platform.utils.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ChatRoomService {
    private final Map<String, ChatRoom> rooms = new HashMap<>();

    public String createRoom(String roomName) {
        if (rooms.containsKey(roomName)) {
            return Constants.ROOM_NAME_ALREADY_EXISTS;
        }
        rooms.put(roomName, new ChatRoom(roomName));
        return Constants.SUCCESS;
    }

    public String addUserToRoom(String username, String roomName) {
        ChatRoom room = rooms.get(roomName);
        if (room == null) {
            return Constants.ROOM_NAME_NOT_FOUND;
        }
        if (room.hasUser(username)) {
            return Constants.USER_ALREADY_ADDED;
        }
        for (ChatRoom otherRoom : rooms.values()) {
            otherRoom.removeUser(username);
        }
        room.addUser(username);
        return Constants.SUCCESS;
    }

    public String getUserRoom(String username) {
        for (ChatRoom room : rooms.values()) {
            if (room.hasUser(username)) {
                return room.getName();
            }
        }
        return null;
    }

    public String listRooms() {
        if (rooms.isEmpty()) {
            return Constants.NO_ROOM_AVAILABLE;
        }
        return rooms.keySet().stream().sorted().collect(Collectors.joining(";"));
    }

    public int getRoomCount() {
        return rooms.size();
    }
}
