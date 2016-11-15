package com.example.espino.scaneat.models;


import java.util.ArrayList;

public class Dish implements Comparable<Dish>{

    private String name,
    restaurantName,
    description,
    ingredients,
    image;

    private ArrayList<String> comentaries;

    private float price,
    globalRating,
    presentationRating,
    qualityPriceRating;

    private ArrayList<Allergens> allergens;

    private ArrayList<String> cuisine;


    public Dish(String name, String restaurantName, String description, String ingredients, float price, float globalRating,
                float presentationRating, float qualityPriceRating, ArrayList allergens, ArrayList comentaries,
                ArrayList cuisine, String pathToImg) {
        this.name = name;
        this.restaurantName = restaurantName;
        this.description = description;
        this.ingredients = ingredients;
        this.price = price;
        this.globalRating = globalRating;
        this.presentationRating = presentationRating;
        this.qualityPriceRating = qualityPriceRating;
        this.image = pathToImg;

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

    public Allergens getAllergens(int position) {
        return allergens.get(position);
    }

    public void setAllergens(int position, Allergens allergen) {
        this.allergens.set(position, allergen);
    }

    public String getComentaries(int position) {
        return comentaries.get(position);
    }

    public void setComentaries(int position, String comment) {
        this.comentaries.set(position,comment) ;
    }

    @Override
    public int compareTo(Dish o) {
        return Float.compare(this.globalRating, o.globalRating);
    }
}
