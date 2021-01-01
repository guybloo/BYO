package com.example.byo.DB;

import com.example.byo.Types.Byo;
import com.example.byo.Types.Event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//import static com.example.apoc.types.HelpMethods.ListfromGson;


/**
 * events db class
 */
public class EventDB extends DBWrapper {
    public static String EVENT_ID = "user_id";
    public static String DESCRIPTION = "description";
    public static String TITLE = "title";
    public static String MAX_PARTICIPANTS = "max_participants";
    public static String TICKET_PRICE = "ticket_price";
    public static String ACTIVITY_ID = "activity_id";
    public static String VENUE_ID = "venue_id";
    public static String SERVICE_IDS = "service_ids";

    /**
     * constructor
     */
    public EventDB() {
        super();
        docName = "events";
    }

    /**
     * updates event item in db
     *
     * @param addItem the item
     */
    @Override
    public void updateItem(DBItem addItem) {
        Event item = (Event) addItem;
        Map<String, Object> newItem = new HashMap<>();

        newItem.put(ID, item.getId());
        newItem.put(DESCRIPTION, item.getDescription());
        newItem.put(TITLE, item.getTitle());
        newItem.put(MAX_PARTICIPANTS, item.getMaxParticipants());
        newItem.put(TICKET_PRICE, item.getTicketPrice());
        newItem.put(ACTIVITY_ID, item.getActivityID());
        newItem.put(VENUE_ID, item.getVenueID());
        newItem.put(SERVICE_IDS, item.getServiceIDs());

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
        Event event = new Event((String) item.get(EVENT_ID),
                (String) item.get(DESCRIPTION),
                (String) item.get(TITLE),
                (int) item.get(MAX_PARTICIPANTS),
                (int) item.get(TICKET_PRICE),
                (String) item.get(ACTIVITY_ID),
                (String) item.get(VENUE_ID),
                (List<String>) item.get(SERVICE_IDS)
        );

        return event;
    }
}
