package com.example.byo.Types;

import com.example.byo.DB.DBItem;

public class Request implements DBItem{
    private String eventID;
    private Byo byo;
    private String status;

    // constructors
    public Request(String eventID, Byo byo, String status) {
        this.eventID = eventID;
        this.byo = byo;
        this.status = status;
    }

    public Request(){}

    // setters
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public void setByo(Byo byo) {
        this.byo = byo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // getters
    public String getEventID() {
        return eventID;
    }

    public Byo getByo() {
        return byo;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String getId() {
        return eventID + "_" + byo.getId();
    }
}
