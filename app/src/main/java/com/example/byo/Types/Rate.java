package com.example.byo.Types;

import com.example.byo.DB.DBItem;

public class Rate implements DBItem {
    private String phoneID;
    private String ratedID;
    private int stars;
    private String description;

    // constructors
    public Rate(String phoneNumID, String ratedID, int stars, String description) {
        this.phoneID = phoneNumID;
        this.ratedID = ratedID;
        this.stars = stars;
        this.description = description;
    }

    public Rate() {

    }

    // setters
    public void setPhoneID(String phoneNumID) {
        this.phoneID = phoneNumID;
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
    public String getPhoneID() {
        return phoneID;
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
        return phoneID + "_" + ratedID;
    }
}
