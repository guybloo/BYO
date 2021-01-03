package com.example.byo.Types;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

import androidx.core.app.ActivityCompat;

import com.example.byo.DB.DBItem;

import java.util.Date;

public class Rate implements DBItem {
    private String phoneNumID;
    private String ratedID;
    private int stars;
    private String description;

    // constructor
    public Rate(String phoneNumID, String ratedID, int stars, String description) {
        this.phoneNumID = phoneNumID;
        this.ratedID = ratedID;
        this.stars = stars;
        this.description = description;
    }

    // setters
    public void setPhoneNumID(String phoneNumID) {
        this.phoneNumID = phoneNumID;
    }

    public void setRatedID(String ratedID) {
        this.ratedID = ratedID;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // getters
    public String getDateTime() {
        return phoneNumID;
    }

    public String getRatedID() {
        return ratedID;
    }

    public int getStars() {
        return stars;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getId() {
        return phoneNumID + "_" + ratedID;
    }
}
