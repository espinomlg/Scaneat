package com.example.espino.scaneat.models;


import java.util.ArrayList;

public class User {


    private String name,
    email,
    password,
    address,
    image;

    private int searchRadius;

    private float radio;

    private ArrayList<Allergens> allergens;

    public User(String name, String email, String password, String address, String image, int searchRadius, float radio, ArrayList<Allergens> allergens) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.image = image;
        this.searchRadius = searchRadius;
        this.radio = radio;
        this.allergens = allergens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSearchRadius() {
        return searchRadius;
    }

    public void setSearchRadius(int searchRadius) {
        this.searchRadius = searchRadius;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public ArrayList<Allergens> getAllergens() {
        return allergens;
    }

    public void setAllergens(ArrayList<Allergens> allergens) {
        this.allergens = allergens;
    }
}
