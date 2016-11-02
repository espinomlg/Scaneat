package com.example.espino.scaneat;

import android.app.Application;

import com.example.espino.scaneat.models.DishItem;
import com.example.espino.scaneat.models.LoginUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ScanEatApplication extends Application {

    private LoginUser user;
    private ArrayList<DishItem> searchResults;


    @Override
    public void onCreate() {
        super.onCreate();

        searchResults = new ArrayList<>();

        for(int i = 30; i > 0; i--){
            searchResults.add(new DishItem("plato","restaurante",i,i,i,true,R.drawable.ic_launcher));
        }
    }

    public List<DishItem> getSearchResults(){
        Collections.sort(searchResults);
        return searchResults;
    }

    public LoginUser getUser(){
        return user;
    }

    public void setUser(LoginUser user){
        this.user = user;
    }
}
