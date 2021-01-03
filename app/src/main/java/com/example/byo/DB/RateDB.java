package com.example.byo.DB;

import com.example.byo.Types.Event;
import com.example.byo.Types.Rate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * rates db class
 */
public class RateDB extends DBWrapper {
    public static String PHONE_ID = "phoneNumID";
    public static String RATED_ID = "ratedID";
    public static String STARS = "stars";
    public static String DESCRIPTION = "description";

    /**
     * constructor
     */
    public RateDB() {
        super();
        docName = "rates";
    }

    /**
     * updates event item in db
     *
     * @param addItem the item
     */
    @Override
    public void updateItem(DBItem addItem) {
        Rate item = (Rate) addItem;
        Map<String, Object> newItem = new HashMap<>();

        newItem.put(PHONE_ID, item.getPhoneID());
        newItem.put(RATED_ID, item.getRatedID());
        newItem.put(STARS, item.getStars());
        newItem.put(DESCRIPTION, item.getDescription());

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
        Rate rate = new Rate();
        rate.setPhoneID((String) item.get(PHONE_ID));
        rate.setRatedID((String) item.get(RATED_ID));
        rate.setStars((int) item.get(STARS));
        rate.setDescription((String) item.get(DESCRIPTION));
        return rate;
    }
}

