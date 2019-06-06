package com.kevin.ebayrecreated;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView dailyDealsRecyclerView;
    RecyclerView featuredSalesAndEventsRecyclerView;
    ArrayList<DailyDealsModel> dailyDealsModelArrayList;
    ArrayList<FeaturedSalesAndEventsModel> featuredSalesAndEventsModelArrayList;

    ImageView floatsImageView, oculusImageView, minecraftImageView, glassesImageView;
    String floatsUrl = "https://i.ebayimg.com/images/g/jfUAAOSwLgZc8VVW/s-l400.jpg";
    String oculusUrl = "https://i.ebayimg.com/images/g/L6sAAOSwT61c8Dza/s-l400.jpg";
    String minecraftUrl = "https://i.ebayimg.com/images/g/01AAAOSwAspc7rDd/s-l400.jpg";
    String glassesUrl = "https://i.ebayimg.com/images/g/MU4AAOSwv0Nc8EpD/s-l1600.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatsImageView = findViewById(R.id.floats_imageview);
        oculusImageView = findViewById(R.id.oculus_imagview);
        minecraftImageView = findViewById(R.id.minecraft_imageview);
        glassesImageView = findViewById(R.id.glasses_imageview);

        Glide.with(getApplicationContext()).load(floatsUrl).into(floatsImageView);
        Glide.with(getApplicationContext()).load(oculusUrl).into(oculusImageView);
        Glide.with(getApplicationContext()).load(minecraftUrl).into(minecraftImageView);
        Glide.with(getApplicationContext()).load(glassesUrl).into(glassesImageView);


        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        dailyDealsRecyclerView = findViewById(R.id.daily_deals_recyclerview);
        dailyDealsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));
        dailyDealsRecyclerView.addItemDecoration(itemDecoration);
        dailyDealsModelArrayList = new ArrayList<>();

        try {
            JSONObject obj = new JSONObject(loadJSON());
            JSONArray jsonArray = obj.getJSONArray("DailyDeals");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject objc = jsonArray.getJSONObject(i);
                dailyDealsModelArrayList.add(new DailyDealsModel(objc));
            }

            dailyDealsRecyclerView.setAdapter(new DailyDealsAdapter(dailyDealsModelArrayList, this));
        } catch (JSONException e) {

        }

        featuredSalesAndEventsRecyclerView = findViewById(R.id.featured_sales_and_events_recyclerview);
        featuredSalesAndEventsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));
        featuredSalesAndEventsRecyclerView.addItemDecoration(itemDecoration);
        featuredSalesAndEventsModelArrayList = new ArrayList<>();

        try {
            JSONObject obj = new JSONObject(loadJSON2());
            JSONArray jsonArray = obj.getJSONArray("Featured");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject objc = jsonArray.getJSONObject(i);
                featuredSalesAndEventsModelArrayList.add(new FeaturedSalesAndEventsModel(objc));
            }

            featuredSalesAndEventsRecyclerView.setAdapter(new FeaturedSalesAndEventsAdapter(featuredSalesAndEventsModelArrayList, this));
        } catch (JSONException e) {
            Log.e("lol", "Error: " + e);

        }
    }

    public String loadJSON() {
        String json = null;
        try {
            InputStream stream = getAssets().open("dailydeals.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public String loadJSON2() {
        String json = null;
        try {
            InputStream stream = getAssets().open("features.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
