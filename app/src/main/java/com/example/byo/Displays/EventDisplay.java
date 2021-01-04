package com.example.byo.Displays;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.byo.CreateEvent;
import com.example.byo.Navigation;
import com.example.byo.R;
import com.example.byo.Types.Byo;
import com.example.byo.Types.Event;

import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.List;

/**
 * shows user details in group
 */
public class EventDisplay extends GenericDisplay{

    public EventDisplay(Event event, final Context context){
        super(event,context, R.layout.event_display);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.openCreateEvent(context, (Event) item);
            }
        });
    }

    @Override
    public void updateUI() {
        super.updateUI();
        ((TextView)view.findViewById(R.id.event_display_title)).setText(((Event)item).getTitle());
        ((TextView)view.findViewById(R.id.event_display_date)).setText(CreateEvent.formatDate(((Event)item).getDateTime()));
    }


}
