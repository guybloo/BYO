package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.byo.DB.DBItem;
import com.example.byo.DB.DBWrapper;
import com.example.byo.DB.EventDB;
import com.example.byo.Displays.EventDisplay;
import com.example.byo.Types.Event;

import java.util.ArrayList;
import java.util.List;

public class AllEvents extends AppCompatActivity {

    List<Event> items;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_events);

        final Context context = this;
        layout = findViewById(R.id.all_events_layout);
        items = new ArrayList<>();
        final EventDB eventDB = new EventDB();
        eventDB.getAllItems();
        eventDB.setDataChangeListener(new DBWrapper.OnDataChangeListener() {
            @Override
            public void onGetAll() {
                for(DBItem item : eventDB.getItems().values()){
                    EventDisplay display = new EventDisplay((Event)item, context, layout, false);
                    display.addView(layout);
                }
            }

            @Override
            public void onGetSpecific() {

            }
        });
    }
}