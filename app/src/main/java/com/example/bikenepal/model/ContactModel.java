package com.example.bikenepal.model;

import com.google.gson.annotations.SerializedName;

public class ContactModel {

    @SerializedName("username") // username name for JavaScript Object Notation(JASON) or other.
    private String username;

    @SerializedName("address")  // address name for JavaScript Object Notation(JASON) or other.
    private String address;

    @SerializedName("job") // job name for JavaScript Object Notation(JASON) or other.
    private String job;

    @SerializedName("description") // description name for JavaScript Object Notation(JASON) or other.
    private String description;

    // Creating class constructor
    public ContactModel(String username, String address , String job, String description) {
        this.username = username;
        this.address = address;
        this.job = job;
        this.description = description;
    }

    // Getter method
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

    public void setUsername(String username){
        this.username = username;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setJob(String job){
        this.job = job;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
