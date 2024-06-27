package com.example.bikenepal.model;

public class BikeModel {

    private String Name;
    private String Price;
    private String FuelTank;
    private int Image;
    private String Url;

    public BikeModel(String name, String price, String fueltank, int image, String url){
        this.Name= name;
        this.Price = price;
        this.FuelTank = fueltank;
        this.Image = image;
        this.Url = url;
    }

    // Getter and Setter method
    public String getName(){
        return Name;
    }

    public String getPrice(){
        return Price;
    }

    public String getFuelTank(){
        return FuelTank;
    }

    public int getImage() {
        return Image;
    }

    public String getUrl() {
        return Url;
    }

    public void setName(String name){
        this.Name = name;
    }

    public void setPrice(String price){
        this.Price = price;
    }

    public void setFuelTank(String fueltank){
        this.FuelTank = fueltank;
    }

    public void setImage(int image){
        this.Image = image;
    }

    public void setUrl(String url){
        this.Url = url;
    }
}
