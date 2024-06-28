package com.example.bikenepal.model;

import com.google.gson.annotations.SerializedName;

public class ContactModel {

    @SerializedName("company") // username name for JavaScript Object Notation(JASON) or other.
    private String company;

    @SerializedName("country")  // address name for JavaScript Object Notation(JASON) or other.
    private String country;

    @SerializedName("name") // job name for JavaScript Object Notation(JASON) or other.
    private String name;

    @SerializedName("description") // description name for JavaScript Object Notation(JASON) or other.
    private String description;

    // Creating class constructor
    public ContactModel(String company, String country, String name, String description) {
        this.company = company;
        this.country = country;
        this.name = name;
        this.description = description;
    }

    // Getter method
    public String getCompany() {
        return company;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setCompany(String company){
        this.company = company;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
