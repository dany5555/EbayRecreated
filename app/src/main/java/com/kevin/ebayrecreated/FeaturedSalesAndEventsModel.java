package com.kevin.ebayrecreated;

import org.json.JSONException;
import org.json.JSONObject;

public class FeaturedSalesAndEventsModel {

    public String dealImageUrl;
    public String deal;
    public String dealDescription;

    public FeaturedSalesAndEventsModel(JSONObject jsonObject) {
        if (jsonObject != null) {
            try {
                dealImageUrl = jsonObject.getString("dealImageUrl");
                deal = jsonObject.getString("dealTextView");
                dealDescription = jsonObject.getString("dealDescription");
            } catch (JSONException e) {
                // Error
            }
        }
    }
}
