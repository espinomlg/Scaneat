package com.example.espino.scaneat.presenters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.espino.scaneat.R;
import com.example.espino.scaneat.ScanEatApplication;
import com.example.espino.scaneat.models.DishItem;

import java.util.ArrayList;
import java.util.Locale;


public class DishItemAdapter extends RecyclerView.Adapter<DishItemAdapter.DishItemViewHolder> {

    private ArrayList<DishItem> searchresults;
    private Context context;

    public DishItemAdapter(Context context){
        this.context = context;
        searchresults = new ArrayList<>(((ScanEatApplication)context.getApplicationContext()).getSearchResults());
    }


    @Override
    public DishItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);

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

            img = (ImageView) item.findViewById(R.id.listitem_image);
            name = (TextView) item.findViewById(R.id.listitem_dishname);
            restaurantName = (TextView) item.findViewById(R.id.listitem_resutaurant);
            rating = (TextView) item.findViewById(R.id.listitem_rating);
            price = (TextView) item.findViewById(R.id.listitem_prices);
            distance = (TextView) item.findViewById(R.id.listitem_distance);
            opened = (TextView) item.findViewById(R.id.listitem_opened);


        }
    }
}
