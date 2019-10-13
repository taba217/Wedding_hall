package com.snaptech.harith;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class Halls {
    @SerializedName("image")
    private String ImageResource;
    private String name;
    @SerializedName("am_prise")
    private String am_price;
    @SerializedName("pm_prise")
    private String pm_price;
    private String location, quantity, rate;

    public Halls(String imageResource, String name, String am_price, String pm_price, String location, String quantity, String rate) {
        ImageResource = imageResource;
        this.name = name;
        this.am_price = am_price;
        this.pm_price = pm_price;
        this.location = location;
        this.quantity = quantity;
        this.rate = rate;
    }

    public String getImageResource() {
        return ImageResource;
    }

    public String getName() {
        return name;
    }

    public String getAm_price() {
        return am_price;
    }

    public String getPm_price() {
        return pm_price;
    }

    public String getLocation() {
        return location;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getRate() {
        return rate;
    }
}
