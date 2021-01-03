package com.example.byo.Displays;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.byo.R;
import com.example.byo.Types.Byo;
import com.example.byo.Types.Event;

import java.util.List;

/**
 * shows user details in group
 */
public class EventDisplay extends GenericDisplay{

    private List<Byo> items;
    private LinearLayout layout;

    public EventDisplay(Event event, final Context context){
        super(event,context);
    }

    @Override
    public void updateUI() {
        super.updateUI();
        ((TextView)view.findViewById(R.id.byo_display_title)).setText(((Event)item).getTitle());
    }
}
