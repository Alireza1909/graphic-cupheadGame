package com.example.apcupheadazmayeshi.Controller;

import com.example.apcupheadazmayeshi.Model.User;

public class SignUpMenuController {
    public boolean isUsernameRepeated(String username){
        for (User user : User.users)
            if (user.getUsername().equals(username))
                return true;
        return false;
    }


    public void createUser(String username, String password) {
        User user = new User(username,password);
        User.users.add(user);
    }
}
