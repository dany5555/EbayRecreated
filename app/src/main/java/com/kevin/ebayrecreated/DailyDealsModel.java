package com.kevin.ebayrecreated;

import org.json.JSONException;
import org.json.JSONObject;

public class DailyDealsModel {

    public String productImageUrl;
    public String productName;
    public String productPrice;
    public String productTimeAvailable;

    public DailyDealsModel(JSONObject jsonObject) {
        if (jsonObject != null) {
            try {
                productImageUrl = jsonObject.getString("productImageUrl");
                productName = jsonObject.getString("productName");
                productPrice = jsonObject.getString("productPrice");
                productTimeAvailable = jsonObject.getString("productTimeAvailable");
            } catch (JSONException e) {
                // Error
            }
        }
    }
}
