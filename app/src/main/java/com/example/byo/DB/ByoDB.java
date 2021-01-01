package com.example.byo.DB;

import com.example.byo.Types.Byo;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;


//import static com.example.apoc.types.HelpMethods.ListfromGson;



/**
 * users db class
 */
public class ByoDB extends DBWrapper {
    public static String USER_ID = "user_id";
    public static String TYPE = "type";
    public static String DESCRIPTION = "description";
    public static String TITLE = "title";
    public static String SUB_TYPE = "sub_type";
    public static String MAX_PARTICIPANTS = "max_participants";
    public static String INSTAGRAM = "instagram";
    public static String FACEBOOK = "facebook";
    public static String OTHER_LINK = "other_link";
    public static String PRICE = "price";

    /**
     * constructor
     */
    public ByoDB(){
        super();
        docName = "byos";
    }

    /**
     * updates user item to db
     * @param addItem the item
     */
    @Override
    public void updateItem(DBItem addItem) {
        Byo item = (Byo)addItem;
        Map<String, Object> newItem = new HashMap<>();
        newItem.put(ID, item.getId());
        newItem.put(USER_ID, item.getUserID());
        newItem.put(TYPE, item.getType());
        newItem.put(DESCRIPTION, item.getDescription());
        newItem.put(TITLE, item.getTitle());
        newItem.put(SUB_TYPE, item.getSubType());
        newItem.put(MAX_PARTICIPANTS, item.getMaxParticipants());
        newItem.put(INSTAGRAM, item.getInstagram());
        newItem.put(FACEBOOK, item.getFacebook());
        newItem.put(OTHER_LINK, item.getOtherLink());
        newItem.put(PRICE, item.getPrice());

        db.collection(docName).document(String.valueOf(item.getId())).set(newItem);
    }

    /**
     * parse user item from db
     * @param item the item
     * @return the user
     */
    @Override
    protected DBItem parseItem(Map<String, Object> item) {
        Byo byo =  new Byo((String) item.get(NICK_NAME),
                (String) item.get(EMAIL),
                (String) item.get(PHONE),
                (String) item.get(STATUS),
                (String) item.get(IMAGE),
                fromGson((String) item.get(LOCATION),LocationInfo.class),
                ListFromGson((String) item.get(SKILLS), Skills.class),
                ListFromGson((String) item.get(FEARS), Fears.class),
                (Boolean) item.get(IS_GROUPED));

        user.addItemsList(ListFromGson((String) item.get(ITEMS),ItemCount.class));
        return user;
    }
}
