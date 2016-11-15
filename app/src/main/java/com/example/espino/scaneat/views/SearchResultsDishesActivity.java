package com.example.espino.scaneat.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.espino.scaneat.R;
import com.example.espino.scaneat.adapters.DishItemAdapter;


public class SearchResultsDishesActivity extends AppCompatActivity {

    private DishItemAdapter adapter;
    private RecyclerView rcvDishes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresults);

        adapter = new DishItemAdapter(SearchResultsDishesActivity.this);
        rcvDishes = (RecyclerView) findViewById(R.id.searchresults_rcv);
        rcvDishes.setLayoutManager(new LinearLayoutManager(SearchResultsDishesActivity.this));
        rcvDishes.setAdapter(adapter);

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
                startActivity(new Intent(SearchResultsDishesActivity.this,UserPreferencesActivity.class));
                break;

            case R.id.menu_generalsettings:
                startActivity(new Intent(SearchResultsDishesActivity.this,GeneralSettingsActivity.class));
                break;

            case R.id.menu_about:
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
