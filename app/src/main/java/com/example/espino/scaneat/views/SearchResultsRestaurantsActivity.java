package com.example.espino.scaneat.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
}
