package com.example.espino.scaneat.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.espino.scaneat.R;
import com.example.espino.scaneat.ScanEatApplication;
import com.example.espino.scaneat.models.RestaurantItem;
import com.example.espino.scaneat.views.RestaurantActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


public class RestaurantItemAdapter extends RecyclerView.Adapter<RestaurantItemAdapter.RestaurantItemViewHolder> {

    private ArrayList<RestaurantItem> searchresults;
    private Context context;

    public RestaurantItemAdapter(Context context){
        this.context = context;
        searchresults = new ArrayList<>(((ScanEatApplication)context.getApplicationContext()).getSearchResultsRestaurants());
    }


    @Override
    public RestaurantItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_restaurant, null);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context.getApplicationContext(), RestaurantActivity.class));
            }
        });

        return new RestaurantItemViewHolder(item);
    }

    @Override
    public void onBindViewHolder(RestaurantItemViewHolder holder, int position) {

        holder.img.setImageResource(searchresults.get(position).getImg());
        holder.name.setText(searchresults.get(position).getName());

        holder.rating.setText(String.format(Locale.getDefault(),"%s s",searchresults.get(position).getRating()));
        holder.address.setText(searchresults.get(position).getAddress());

    }


    @Override
    public int getItemCount() {
        return searchresults.size();
    }


    public void sortByRating(){
        Collections.reverse(searchresults);
        notifyDataSetChanged();
    }

    public static class RestaurantItemViewHolder extends RecyclerView.ViewHolder{

        private TextView name, address, rating;
        private ImageView img;

        public RestaurantItemViewHolder(View item) {
            super(item);

            img = (ImageView) item.findViewById(R.id.listitem_restaurant_img);
            name = (TextView) item.findViewById(R.id.listitem_restaurant_name);
            address = (TextView) item.findViewById(R.id.listitem_restaurant_address);
            rating = (TextView) item.findViewById(R.id.listitem_restaurant_rate);

        }
    }
}
