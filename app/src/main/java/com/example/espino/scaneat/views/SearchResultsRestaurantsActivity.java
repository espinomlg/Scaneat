package com.example.espino.scaneat.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.espino.scaneat.R;
import com.example.espino.scaneat.adapters.RestaurantItemAdapter;



public class SearchResultsRestaurantsActivity extends AppCompatActivity {

    private RestaurantItemAdapter adapter;
    private RecyclerView rcvRestaurants;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresults);

        adapter = new RestaurantItemAdapter(SearchResultsRestaurantsActivity.this);
        rcvRestaurants = (RecyclerView) findViewById(R.id.searchresults_rcv);
        rcvRestaurants.setLayoutManager(new LinearLayoutManager(SearchResultsRestaurantsActivity.this));
        rcvRestaurants.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.action_bar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_action_sort:
                adapter.sortByRating();
                break;

            case R.id.menu_filters:
                break;

            case R.id.menu_userpreferences:
                startActivity(new Intent(SearchResultsRestaurantsActivity.this,UserPreferencesActivity.class));
                break;

            case R.id.menu_generalsettings:
                startActivity(new Intent(SearchResultsRestaurantsActivity.this,GeneralSettingsActivity.class));
                break;

            case R.id.menu_about:
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
