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

public class FeaturedSalesAndEventsAdapter extends RecyclerView.Adapter<FeaturedSalesAndEventsAdapter.ViewHolder>{

    ArrayList<FeaturedSalesAndEventsModel> featuredSalesAndEventsModelArrayList;
    Context context;

    public FeaturedSalesAndEventsAdapter(ArrayList<FeaturedSalesAndEventsModel> featuredSalesAndEventsModelArrayList, Context context) {
        this.featuredSalesAndEventsModelArrayList = featuredSalesAndEventsModelArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.featured_sales_and_events_recyclerview_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedSalesAndEventsAdapter.ViewHolder viewHolder, int i) {
        FeaturedSalesAndEventsModel featuredSalesAndEventsModel = featuredSalesAndEventsModelArrayList.get(i);

        Glide.with(context).load(featuredSalesAndEventsModel.dealImageUrl).into(viewHolder.dealImageView);
        viewHolder.dealTextView.setText(featuredSalesAndEventsModel.deal);
        viewHolder.dealDescriptionTextView.setText(featuredSalesAndEventsModel.dealDescription);

    }

    @Override
    public int getItemCount() {
        return featuredSalesAndEventsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView dealImageView;
        TextView dealTextView;
        TextView dealDescriptionTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dealImageView = itemView.findViewById(R.id.dealImageView);
            dealTextView = itemView.findViewById(R.id.dealTextView);
            dealDescriptionTextView = itemView.findViewById(R.id.dealDescriptionTextView);


        }
    }
}
