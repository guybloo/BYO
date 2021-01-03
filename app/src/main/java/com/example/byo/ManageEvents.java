package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.byo.DB.DBItem;
import com.example.byo.DB.DBWrapper;
import com.example.byo.DB.EventDB;
import com.example.byo.Displays.ByoDisplay;
import com.example.byo.Displays.EventDisplay;
import com.example.byo.Types.Byo;
import com.example.byo.Types.CurrentUser;
import com.example.byo.Types.Event;

import java.util.ArrayList;
import java.util.List;

public class ManageEvents extends AppCompatActivity {

    private List<Event> items;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_events);

        layout = findViewById(R.id.layout_manage_events);
        items = new ArrayList<>();

        loadEvents();
    }

    private void loadEvents()
    {
        final EventDB db = new EventDB();
        db.loadItemsByFieldFromDB(EventDB.OWNER_ID, CurrentUser.getEmail());
        db.setDataChangeListener(new DBWrapper.OnDataChangeListener() {
            @Override
            public void onGetAll() {

            }

            @Override
            public void onGetSpecific() {
                items.clear();
                for(DBItem event : db.getItems().values()){
                    items.add((Event)event);
                }
                updateEvents();
            }
        });
    }

    private void updateEvents(){
        layout.removeAllViews();

        for(Event item : items){
            EventDisplay display = new EventDisplay(item, this);
            display.addView(layout);
        }
    }
}