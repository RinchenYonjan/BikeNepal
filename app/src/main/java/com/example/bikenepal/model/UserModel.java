package com.example.bikenepal.model;

import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("username") // username name for JavaScript Object Notation(JASON).
    private String username;

    @SerializedName("email")    // email name for JavaScript Object Notation(JASON).
    private String email;

    @SerializedName("phonenumber")  // phonenumber name for JavaScript Object Notation(JASON).
    private String phonenumber;

    @SerializedName("password") // password name for JavaScript Object Notation(JASON).
    private String password;

    // Creating class constructor
    public UserModel(String username, String email, String phonenumber, String password) {
        this.username = username;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    // Getter and Setter method
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
