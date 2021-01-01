package com.example.byo.DB;

import com.example.byo.Types.Byo;
import com.example.byo.Types.Event;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//import static com.example.apoc.types.HelpMethods.ListfromGson;


/**
 * events db class
 */
public class EventDB extends DBWrapper {
    public static String NUM_ID = "num_id";
    public static String DESCRIPTION = "description";
    public static String TITLE = "title";
    public static String MAX_PARTICIPANTS = "max_participants";
    public static String TICKET_PRICE = "ticket_price";
    public static String ACTIVITY_ID = "activity_id";
    public static String VENUE_ID = "venue_id";
    public static String SERVICE_IDS = "service_ids";
    public static String OWNER_ID = "owner_id";
    public static String DATE = "date";

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

        newItem.put(NUM_ID, item.getNumID());
        newItem.put(DESCRIPTION, item.getDescription());
        newItem.put(TITLE, item.getTitle());
        newItem.put(MAX_PARTICIPANTS, item.getMaxParticipants());
        newItem.put(TICKET_PRICE, item.getTicketPrice());
        newItem.put(ACTIVITY_ID, item.getActivityID());
        newItem.put(VENUE_ID, item.getVenueID());
        newItem.put(SERVICE_IDS, item.getServiceIDs());
        newItem.put(OWNER_ID, item.getOwnerID());
        newItem.put((DATE, item.getDateTime());

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
        Event event = new Event();
        event.setNumID((long) item.get(NUM_ID));
        event.setDescription((String) item.get(DESCRIPTION));
        event.setTitle((String) item.get(TITLE));
        event.setMaxParticipants((int) item.get(MAX_PARTICIPANTS));
        event.setTicketPrice((int) item.get(TICKET_PRICE));
        event.setActivityID((String) item.get(ACTIVITY_ID));
        event.setVenueID((String) item.get(VENUE_ID));
        event.setServiceIDs((List<String>) item.get(SERVICE_IDS));
        event.setDateTime((Date) item.get(DATE));

        return event;
    }
}
