package com.chatter.platform.commands;

import com.chatter.platform.services.UserService;
import com.chatter.platform.utils.Constants;

public class LoginCommand implements Command {
    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(String[] args) {
        if (args.length != 2) {
            return Constants.REQUEST_PATTERN_INVALID;
        }

        String username = args[1];
        return userService.loginUser(username);
    }
}
