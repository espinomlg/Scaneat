package com.example.espino.scaneat.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.espino.scaneat.R;
import com.example.espino.scaneat.presenters.DishItemAdapter;


public class SearchResultsActivity extends AppCompatActivity {

    private DishItemAdapter adapter;
    private RecyclerView rcvDishes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresults);

        adapter = new DishItemAdapter(SearchResultsActivity.this);
        rcvDishes = (RecyclerView) findViewById(R.id.searchresults_rcv);
        rcvDishes.setLayoutManager(new LinearLayoutManager(SearchResultsActivity.this));
        rcvDishes.setAdapter(adapter);

    }
}
