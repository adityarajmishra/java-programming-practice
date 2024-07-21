package com.chatter.platform.commands;

import com.chatter.platform.services.UserService;
import com.chatter.platform.services.ChatRoomService;
import com.chatter.platform.utils.Constants;

public class UserDetailCommand implements Command {
    private final UserService userService;
    private final ChatRoomService chatRoomService;

    public UserDetailCommand(UserService userService, ChatRoomService chatRoomService) {
        this.userService = userService;
        this.chatRoomService = chatRoomService;
    }

    @Override
    public String execute(String[] args) {
        if (args.length != 2) {
            return Constants.REQUEST_PATTERN_INVALID;
        }

        String username = args[1];
        return userService.getUserDetail(username, chatRoomService);
    }
}
