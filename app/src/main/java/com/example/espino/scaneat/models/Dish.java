package com.example.espino.scaneat.models;


import java.util.ArrayList;

public class Dish {

    private String name,
    restaurantName,
    description,
    ingredients;

    private ArrayList<String> comentaries;

    private float price,
    globalRating,
    presentationRating,
    qualityPriceRating,
    qualityRating;

    private ArrayList<String> allergens;

    private ArrayList<String> cuisine;


    public Dish(String name, String restaurantName, String description, String ingredients, float price, float globalRating,
                float presentationRating, float qualityPriceRating, float qualityRating, ArrayList allergens, ArrayList comentaries,
                ArrayList cuisine) {
        this.name = name;
        this.restaurantName = restaurantName;
        this.description = description;
        this.ingredients = ingredients;
        this.price = price;
        this.globalRating = globalRating;
        this.presentationRating = presentationRating;
        this.qualityPriceRating = qualityPriceRating;
        this.qualityRating = qualityRating;
        this.allergens = allergens;
        this.comentaries = comentaries;
        this.cuisine = cuisine;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getGlobalRating() {
        return globalRating;
    }

    public void setGlobalRating(float globalRating) {
        this.globalRating = globalRating;
    }

    public float getPresentationRating() {
        return presentationRating;
    }

    public void setPresentationRating(float presentationRating) {
        this.presentationRating = presentationRating;
    }

    public float getQualityPriceRating() {
        return qualityPriceRating;
    }

    public void setQualityPriceRating(float qualityPriceRating) {
        this.qualityPriceRating = qualityPriceRating;
    }

    public float getQualityRating() {
        return qualityRating;
    }

    public void setQualityRating(float qualityRating) {
        this.qualityRating = qualityRating;
    }

    public String getAllergens(int position) {
        return allergens.get(position);
    }

    public void setAllergens(int position, String commentary) {
        this.allergens.set(position, commentary);
    }

    public String getComentaries(int position) {
        return comentaries.get(position);
    }

    public void setComentaries(int position, String comment) {
        this.comentaries.set(position,comment) ;
    }
}
