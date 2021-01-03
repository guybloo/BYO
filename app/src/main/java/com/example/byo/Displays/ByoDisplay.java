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

/**
 * shows user details in group
 */
public class ByoDisplay extends GenericDisplay {
    // user is the one who sees this page, other user is another group member to show


    public ByoDisplay(Byo byo, final Context context){
        super(byo, context,R.layout.byo_display);
    }

    @Override
    public void updateUI() {
        super.updateUI();
        ((TextView)view.findViewById(R.id.byo_display_title)).setText(((Byo)item).getTitle());
    }


}
