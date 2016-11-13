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
import com.example.espino.scaneat.models.DishItem;
import com.example.espino.scaneat.views.DishActivity;

import java.util.ArrayList;
import java.util.Locale;


public class DishItemAdapter extends RecyclerView.Adapter<DishItemAdapter.DishItemViewHolder> {

    private ArrayList<DishItem> searchresults;
    private Context context;
    private View.OnClickListener listener;

    public DishItemAdapter(Context context){
        this.context = context;
        searchresults = new ArrayList<>(((ScanEatApplication)context.getApplicationContext()).getSearchResultsDish());
    }

    public void setOnClickListener(View.OnClickListener listener){
        if(this.listener != null)
            this.listener = listener;
    }

    @Override
    public DishItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_dish, null);

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context.getApplicationContext(), DishActivity.class));
            }
        });

        return new DishItemViewHolder(item);
    }

    @Override
    public void onBindViewHolder(DishItemViewHolder holder, int position) {

        holder.img.setImageResource(searchresults.get(position).getImage());
        holder.name.setText(searchresults.get(position).getName());
        holder.restaurantName.setText(searchresults.get(position).getRestaurantName());
        holder.rating.setText(String.format(Locale.getDefault(),"%s s",searchresults.get(position).getRating()));
        holder.price.setText(searchresults.get(position).getFormattedPrice());
        holder.distance.setText(searchresults.get(position).getFormattedDistance());
        holder.opened.setText(searchresults.get(position).isOpened() ?
                context.getResources().getString(R.string.restaurant_open) : context.getResources().getString(R.string.restaurant_close));
    }


    @Override
    public int getItemCount() {
        return searchresults.size();
    }


    public static class DishItemViewHolder extends RecyclerView.ViewHolder{

        private TextView name, restaurantName, rating, price, distance, opened;
        private ImageView img;

        public DishItemViewHolder(View item) {
            super(item);

            img = (ImageView) item.findViewById(R.id.listitem_dish_image);
            name = (TextView) item.findViewById(R.id.listitem_dish_dishname);
            restaurantName = (TextView) item.findViewById(R.id.listitem_dish_resutaurant);
            rating = (TextView) item.findViewById(R.id.listitem_dish_rating);
            price = (TextView) item.findViewById(R.id.listitem_dish_prices);
            distance = (TextView) item.findViewById(R.id.listitem_dish_distance);
            opened = (TextView) item.findViewById(R.id.listitem_dish_opened);


        }
    }
}
