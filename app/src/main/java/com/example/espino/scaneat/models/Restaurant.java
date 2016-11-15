package com.example.espino.scaneat.models;


import java.util.ArrayList;

public class Restaurant implements Comparable<Restaurant> {

    private String name,
    description,
    image,
    emai,
    movil,
    tlf,
    optTlf,
    address,
    city,
    web,
    facebook,
    twitter;

    private float globalRating,
    qualityPriceRating,
    presentationRating;

    private ArrayList<String> cuisine;

    public Restaurant(String name, String description, String image, String emai, String movil, String tlf, String optTlf, String address,
                      String city, String web, String facebook, String twitter, float globalRating, float qualityPriceRating, float presentationRating, ArrayList<String> cuisine) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.emai = emai;
        this.movil = movil;
        this.tlf = tlf;
        this.optTlf = optTlf;
        this.address = address;
        this.city = city;
        this.web = web;
        this.facebook = facebook;
        this.twitter = twitter;
        this.globalRating = globalRating;
        this.qualityPriceRating = qualityPriceRating;
        this.presentationRating = presentationRating;
        this.cuisine = cuisine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getOptTlf() {
        return optTlf;
    }

    public void setOptTlf(String optTlf) {
        this.optTlf = optTlf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public float getGlobalRating() {
        return globalRating;
    }

    public void setGlobalRating(float globalRating) {
        this.globalRating = globalRating;
    }

    public float getQualityPriceRating() {
        return qualityPriceRating;
    }

    public void setQualityPriceRating(float qualityPriceRating) {
        this.qualityPriceRating = qualityPriceRating;
    }

    public float getPresentationRating() {
        return presentationRating;
    }

    public void setPresentationRating(float presentationRating) {
        this.presentationRating = presentationRating;
    }

    public ArrayList<String> getCuisine() {
        return cuisine;
    }

    public void setCuisine(ArrayList<String> cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public int compareTo(Restaurant o) {
        return Float.compare(this.globalRating, o.globalRating);
    }
}
