package com.example.byo.Types;

import android.location.Geocoder;

import com.example.byo.DB.DBItem;
import com.example.byo.Enums.ByoType;

import java.io.Serializable;

public class Byo implements DBItem, Serializable {
    public final static String SER_LABEL = "byo";
    private String userID;
    private ByoType type;
    private String description;
    private String title;
    private String subType;
    private int maxParticipants;
    private String instagram;
    private String facebook;
    private String otherLink;
    private int price;
    private long idNum;
    private String address;
    private double longitude; // TODO insert through geocoder
    private double latitude;


    public Byo(){
        idNum = System.currentTimeMillis();
    };

    public Byo(String userID, ByoType type, String description, String title, String subType, int maxParticipants, String instagram, String facebook, String otherLink, int price) {
        this.userID = userID;
        this.type = type;
        this.description = description;
        this.title = title;
        this.subType = subType;
        this.maxParticipants = maxParticipants;
        this.instagram = instagram;
        this.facebook = facebook;
        this.otherLink = otherLink;
        this.price = price;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public void setOtherLink(String otherLink) {
        this.otherLink = otherLink;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(ByoType type) {
        this.type = type;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setIdNum(long idNum) {
        this.idNum = idNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getAddress() {
        return address;
    }

    @Override
    public String getId() {
        return userID + "_" + idNum;
    }

    public ByoType getType() {
        return type;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public int getPrice() {
        return price;
    }

    public String getSubType() {
        return subType;
    }


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getUserID() {
        return userID;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getOtherLink() {
        return otherLink;
    }

    public long getIdNum() {
        return idNum;
    }
}
