package com.example.bikenepal.recyclerview;

public class BikeModel {

    String Name;
    String Price;
    String FuelTank;
    int Image;

    public BikeModel(String name, String price, String fueltank, int image){
        this.Name= name;
        this.Price = price;
        this.FuelTank = fueltank;
        this.Image = image;
    }

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

    public void setName(String name){
        this.Name = name;
    }

    public void setPrice(String price){
        this.Price = price;
    }

    public void setMileage(String fueltank){
        this.FuelTank = fueltank;
    }

    public void setImage(int image){
        this.Image = image;
    }

}
