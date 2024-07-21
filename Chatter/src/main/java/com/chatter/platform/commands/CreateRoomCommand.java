package com.chatter.platform.commands;

import com.chatter.platform.services.ChatRoomService;
import com.chatter.platform.utils.Constants;

public class CreateRoomCommand implements Command {
    private final ChatRoomService chatRoomService;

    public CreateRoomCommand(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @Override
    public String execute(String[] args) {
        if (args.length != 2) {
            return Constants.REQUEST_PATTERN_INVALID;
        }

        String roomName = args[1];
        if (roomName.contains(" ") || roomName.contains(";")) {
            return Constants.REQUEST_PATTERN_INVALID;
        }

        return chatRoomService.createRoom(roomName);
    }
}
