package com.kevin.ebayrecreated;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DailyDealsAdapter extends RecyclerView.Adapter<DailyDealsAdapter.ViewHolder> {

    ArrayList<DailyDealsModel> dailyDealsModelArrayList;
    Context context;

    public DailyDealsAdapter(ArrayList<DailyDealsModel> dailyDealsModelArrayList, Context context) {
        this.dailyDealsModelArrayList = dailyDealsModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.daily_deals_recyclerview_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyDealsAdapter.ViewHolder viewHolder, int i) {
        DailyDealsModel dailyDealsModel = dailyDealsModelArrayList.get(i);

        Glide.with(context).load(dailyDealsModel.productImageUrl).into(viewHolder.productImageView);
        viewHolder.productName.setText(dailyDealsModel.productName);
        viewHolder.productPrice.setText(dailyDealsModel.productPrice);
        viewHolder.productTimeAvailable.setText(dailyDealsModel.productTimeAvailable);


    }

    @Override
    public int getItemCount() {
        return dailyDealsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView productImageView;
        TextView productName;
        TextView productPrice;
        TextView productTimeAvailable;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImageView = itemView.findViewById(R.id.product_imageview);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productTimeAvailable = itemView.findViewById(R.id.product_time_available);


        }
    }
}
