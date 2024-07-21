package com.chatter.platform.commands;

import com.chatter.platform.services.UserService;
import com.chatter.platform.services.ChatRoomService;
import com.chatter.platform.utils.Constants;

public class AddUserCommand implements Command {
    private final UserService userService;
    private final ChatRoomService chatRoomService;

    public AddUserCommand(UserService userService, ChatRoomService chatRoomService) {
        this.userService = userService;
        this.chatRoomService = chatRoomService;
    }

    @Override
    public String execute(String[] args) {
        if (args.length != 4 || !args[2].equalsIgnoreCase("TO")) {
            return Constants.REQUEST_PATTERN_INVALID;
        }

        String username = args[1];
        String roomName = args[3];

        if (!userService.isUserRegistered(username)) {
            return Constants.USERNAME_NOT_FOUND;
        }

        if (!userService.isUserLoggedIn(username)) {
            return Constants.USERNAME_NOT_ONLINE;
        }

        return chatRoomService.addUserToRoom(username, roomName);
    }
}
