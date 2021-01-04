package com.example.byo.Types;

import com.example.byo.DB.DBItem;
import com.example.byo.Enums.RequestStatus;

public class Request implements DBItem{
    private String eventID;
    private String byoID;
    private RequestStatus status;

    // constructors
    public Request(String eventID, String byoID, RequestStatus status) {
        this.eventID = eventID;
        this.byoID = byoID;
        this.status = status;
    }

    public Request(){
        status = RequestStatus.ממתין;
    }

    // setters
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public void setByoID(String byoID) {
        this.byoID = byoID;
    }

    // getters
    public String getEventID() {
        return eventID;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public String getByoID() {
        return byoID;
    }

    @Override
    public String getId() {
        return eventID + "_" + byoID;
    }
}
