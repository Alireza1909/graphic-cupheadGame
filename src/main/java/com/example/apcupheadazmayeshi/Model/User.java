package com.example.apcupheadazmayeshi.Model;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    public static ArrayList<User> users = new ArrayList<>();
    public static User loggedInUser;


    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
