package com.example.espino.scaneat.models;



public class RestaurantItem implements Comparable<RestaurantItem>{

    private String name, address;
    private int img;
    private float rating;

    public RestaurantItem(String name, String address, float rating, int img){
        this.name = name;
        this.address = address;
        this.img = img;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(RestaurantItem o) {
        return Float.compare(this.rating, o.rating);
    }
}
