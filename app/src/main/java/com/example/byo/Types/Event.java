// TODO rewrite to event

package com.example.byo.Types;

import com.example.byo.DB.DBItem;
import com.example.byo.Enums.ByoType;

import java.util.Date;
import java.util.List;

public class Event implements DBItem {
    private long numID;
    private String description;
    private String title;
    private int maxParticipants;
    private int ticketPrice;
    private String activityID;
    private String venueID;
    private List<String> serviceIDs;
    private Date time;
    private String ownerID;


    public Event(){
        this.numID = System.currentTimeMillis();
    }

    public Event(long numId, String description, String title, Date time, String ownerID, int maxParticipants, int ticketPrice, String activityID, String venueID, List<String> serviceIDs) {
        this.numID = numId; // creator's ID + creation time
        this.description = description;
        this.title = title;
        this.time = time;
        this.ownerID = ownerID;
        this.maxParticipants = maxParticipants; // TODO take from all byos
        this.ticketPrice = ticketPrice; // TODO take from all byos
        this.activityID = activityID;
        this.venueID = venueID;
        this.serviceIDs = serviceIDs;
    }

    // setters


    public void setTime(Date time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setActivityID(String activityID) {
        this.title = activityID;
    }

    public void setVenueID(String venueID) {
        this.venueID = venueID;
    }

    public void setServiceIDs(List<String> serviceIDs) {
        this.serviceIDs = serviceIDs;
    }

    // getters


    public Date getTime() {
        return time;
    }

    @Override
    public String getId() {
        return ownerID + "_" + numID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public long getNumID() {
        return numID;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {return title; }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public String getActivityID() { return activityID; }

    public String getVenueID() { return venueID; }

    public List<String> getServiceIDs() { return serviceIDs; }
}
