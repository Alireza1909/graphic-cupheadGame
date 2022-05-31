package com.example.apcupheadazmayeshi.Controller;

import com.example.apcupheadazmayeshi.Model.User;

public class LoginMenuController {

    public User getExistingUser(String currentPassword, String currentUsername) {
        for (User user : User.users) {
            if (user.getUsername().equals(currentUsername)
                    && user.getPassword().equals(currentPassword)) return user;
        }
        return null;
    }

}
