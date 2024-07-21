package com.chatter.platform.commands;

import com.chatter.platform.services.ChatRoomService;

public class ListRoomsCommand implements Command {
    private final ChatRoomService chatRoomService;

    public ListRoomsCommand(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @Override
    public String execute(String[] args) {
        return chatRoomService.listRooms();
    }
}
