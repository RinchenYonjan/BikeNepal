package com.example.bikenepal.model;

import com.google.gson.annotations.SerializedName;

public class ContactModel {

    @SerializedName("username") // Username name for JavaScript Object Notation(JASON).
    private String username;

    @SerializedName("address")  // address name for JavaScript Object Notation(JASON).
    private String address;

    @SerializedName("job") // job name for JavaScript Object Notation(JASON).
    private String job;

    @SerializedName("description") // description name for JavaScript Object Notation(JASON).
    private String description;

    // Creating constructor
    public ContactModel(String username, String address , String job, String description) {
        this.username = username;
        this.address = address;
        this.job = job;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getJob() {
        return job;
    }

    public String getDescription() {
        return description;
    }
}
