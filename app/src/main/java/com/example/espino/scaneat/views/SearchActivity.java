package com.example.espino.scaneat.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.espino.scaneat.R;



public class SearchActivity extends AppCompatActivity {

    private TextInputLayout txiUbication, txiKeyword;
    private Spinner spnCuisine;
    private CheckBox cbDish, cbRestaurant;
    private boolean searchDish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        txiUbication = (TextInputLayout) findViewById(R.id.search_txi_ubication);
        txiKeyword = (TextInputLayout) findViewById(R.id.search_txi_keyword);
        spnCuisine = (Spinner) findViewById(R.id.search_spn_cuisine);
        cbDish = (CheckBox) findViewById(R.id.search_cb_dish);
        cbRestaurant = (CheckBox) findViewById(R.id.search_cb_restaurant);

        searchDish = true;

        loadspnCuisine();
    }

    public void onCheckBoxClick(View v){

        switch (v.getId()){
            case R.id.search_cb_dish:
                cbDish.setChecked(true);
                cbRestaurant.setChecked(false);
                searchDish = true;
                break;

            case R.id.search_cb_restaurant:
                cbDish.setChecked(false);
                cbRestaurant.setChecked(true);
                searchDish = false;
                break;
        }
    }

    public void search(View v){
        startActivity(new Intent(SearchActivity.this, searchDish ?
        SearchResultsDishesActivity.class : SearchResultsRestaurantsActivity.class));
    }

    public void loadspnCuisine(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(SearchActivity.this,
                R.array.cuisine,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCuisine.setAdapter(adapter);

    }
}
