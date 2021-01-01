// TODO rewrite to event

package com.example.byo.Types;

import com.example.byo.DB.DBItem;
import com.example.byo.Enums.ByoType;

import java.util.List;

public class Event implements DBItem {
    public String eventID;
    public String description;
    public String title;
    public int maxParticipants;
    public int ticketPrice;
    public String activityID;
    public String venueID;
    public List<String> serviceIDs;

    public Event(String eventID, String description, String title, int maxParticipants, int ticketPrice, String activityID, String venueID, List<String> serviceIDs) {
        this.eventID = eventID; // creator's ID + creation time
        this.description = description;
        this.title = title;
        this.maxParticipants = maxParticipants; // TODO take from all byos
        this.ticketPrice = ticketPrice; // TODO take from all byos
        this.activityID = activityID;
        this.venueID = venueID;
        this.serviceIDs = serviceIDs;
    }

    // setters

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

    @Override
    public String getId() {
        return eventID;
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
