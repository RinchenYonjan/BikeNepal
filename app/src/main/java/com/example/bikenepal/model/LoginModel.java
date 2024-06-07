package com.example.bikenepal.model;

import com.google.gson.annotations.SerializedName;

public class LoginModel {

    @SerializedName("username") // username name for JavaScript Object Notation(JASON).
    private String username;

    @SerializedName("password") // password name for JavaScript Object Notation(JASON).
    private String password;


    //Creating constructor
    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
