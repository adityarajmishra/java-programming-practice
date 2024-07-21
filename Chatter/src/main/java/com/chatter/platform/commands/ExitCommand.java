package com.chatter.platform.commands;

import com.chatter.platform.services.UserService;
import com.chatter.platform.services.ChatRoomService;

public class ExitCommand implements Command {
    private final UserService userService;
    private final ChatRoomService chatRoomService;

    public ExitCommand(UserService userService, ChatRoomService chatRoomService) {
        this.userService = userService;
        this.chatRoomService = chatRoomService;
    }

    @Override
    public String execute(String[] args) {
        return String.format("User Count: %d\nChat Room Count: %d\nGoodbye!",
                userService.getUserCount(), chatRoomService.getRoomCount());
    }
}
