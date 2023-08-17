package com.domaine.model;

public class AppUser {

    private int id;

    private final String username;

    private final String password;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
