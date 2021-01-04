package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

import com.example.byo.DB.EventDB;
import com.example.byo.Types.Event;

public class EventViewer extends AppCompatActivity {
    public static String intentEventID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_viewer);

        String id = getIntent().getStringExtra(intentEventID);

        EventDB db = new EventDB();
        db.loadItemByIdFromDB(id);
        Event ev = (Event) db.getItemById(id);

        ((TextView) findViewById(R.id.event_title)).setText(ev.getTitle());
        ((TextView) findViewById(R.id.event_description)).setText(ev.getDescription());

        ((TextView) findViewById(R.id.ticket_price)).setText(String.format("%dשח", ev.getTicketPrice()));
        ((TextView) findViewById(R.id.date)).setText(ev.getDateTime().toString());

        // TODO show location on map
    }

    // buy botton not implemented
}