package com.example.espino.scaneat;

import android.app.Application;


import com.example.espino.scaneat.models.DishItem;
import com.example.espino.scaneat.models.LoginUser;
import com.example.espino.scaneat.models.RestaurantItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ScanEatApplication extends Application {

    private LoginUser user;
    private ArrayList<DishItem> searchResultsDish;
    private ArrayList<RestaurantItem>searchResultsRestaurants;


    @Override
    public void onCreate() {
        super.onCreate();

        searchResultsDish = new ArrayList<>();

        for(int i = 30; i > 0; i--){
            searchResultsDish.add(new DishItem("plato","restaurante",i,i,i,true,R.drawable.ic_launcher));
        }

        searchResultsRestaurants = new ArrayList<>();

        for(int i = 30; i > 0; i--){
            searchResultsRestaurants.add(new RestaurantItem("restaurante", "dirección", i,R.drawable.ic_launcher));
        }
    }

    public List<DishItem> getSearchResultsDish(){
        Collections.sort(searchResultsDish);
        return searchResultsDish;
    }

    public List<RestaurantItem> getSearchResultsRestaurants(){
        Collections.sort(searchResultsRestaurants);
        return searchResultsRestaurants;
    }

    public LoginUser getUser(){
        return user;
    }

    public void setUser(LoginUser user){
        this.user = user;
    }
}
