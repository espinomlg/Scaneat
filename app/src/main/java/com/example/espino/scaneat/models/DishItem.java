package com.example.espino.scaneat.models;


import java.text.DecimalFormat;

public class DishItem implements Comparable<DishItem>{

    private String name, restaurantName;
    private float rating, price, distance;
    private int image;
    private boolean opened;

    public DishItem(String name, String restaurantName, float rating, float price, float distance, boolean opened, int image){
        this.name = name;
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.price = price;
        this.distance = distance;
        this.opened = opened;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getPrice() {
        return price;
    }

    public String getFormattedPrice() {
        DecimalFormat decimal = new DecimalFormat("0.00");
        return decimal.format(price) + " €";
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDistance() {
        return distance;
    }

    public String getFormattedDistance() {
        DecimalFormat decimal = new DecimalFormat("0.00");
        return decimal.format(distance) + " km";
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int compareTo(DishItem o) {
        return Double.compare(this.distance, o.distance);
    }
}
