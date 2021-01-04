package com.example.byo.DB;

import com.example.byo.Enums.RequestStatus;
import com.example.byo.Types.Byo;
import com.example.byo.Types.Rate;
import com.example.byo.Types.Request;

import java.util.HashMap;
import java.util.Map;

public class RequestDB extends DBWrapper{
    public static String EVENT_ID = "event_id";
    public static String BYO_ID = "byo_id";
    public static String STATUS = "status";

    /**
     * constructor
     */
    public RequestDB() {
        super();
        docName = "requests";
    }

    /**
     * updates event item in db
     *
     * @param addItem the item
     */
    @Override
    public void updateItem(DBItem addItem) {
        Request item = (Request) addItem;
        Map<String, Object> newItem = new HashMap<>();

        newItem.put(EVENT_ID, item.getEventID());
        newItem.put(BYO_ID, item.getByoID());
        newItem.put(STATUS, item.getStatus());

        db.collection(docName).document(String.valueOf(item.getId())).set(newItem);
    }

    /**
     * parse user item from db
     *
     * @param item the item
     * @return the user
     */
    @Override
    protected DBItem parseItem(Map<String, Object> item) {
        Request request = new Request();
        request.setEventID((String) item.get(EVENT_ID));
        request.setByoID((String) item.get(BYO_ID));
        request.setStatus(RequestStatus.valueOf((String)item.get(STATUS)));

        return request;
    }
}


