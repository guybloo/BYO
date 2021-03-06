package com.example.byo.DB;

import com.example.byo.Enums.ByoType;
import com.example.byo.Types.Byo;
import com.google.firestore.v1.PreconditionOrBuilder;

import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;


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
    public static String ID_NUM = "id_num";
    public static String ADDRESS = "address";

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
        newItem.put(ID_NUM, item.getIdNum());
        newItem.put(ADDRESS, item.getAddress());

        db.collection(docName).document(String.valueOf(item.getId())).set(newItem);
    }

    /**
     * parse user item from db
     * @param item the item
     * @return the user
     */
    @Override
    protected DBItem parseItem(Map<String, Object> item) {
        Byo byo =  new Byo();
        byo.setIdNum((long)item.get(ID_NUM));
        byo.setDescription((String) item.get(DESCRIPTION));
        byo.setFacebook((String) item.get(FACEBOOK));
        byo.setInstagram((String) item.get(INSTAGRAM));
        byo.setMaxParticipants(Integer.parseInt(item.get(MAX_PARTICIPANTS).toString()));
        byo.setOtherLink((String) item.get(OTHER_LINK));
        byo.setSubType(item.get(SUB_TYPE).toString());
        byo.setPrice(Integer.parseInt(item.get(PRICE).toString()));
        byo.setTitle((String) item.get(TITLE));
        byo.setUserID((String) item.get(USER_ID));
        byo.setType(ByoType.valueOf(item.get(TYPE).toString()));
        byo.setAddress((String) item.get(ADDRESS));

        return byo;
    }
}
