package com.example.byo.Displays;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.byo.Enums.ByoType;
import com.example.byo.R;
import com.example.byo.Types.Byo;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;
import net.steamcrafted.materialiconlib.MaterialIconView;

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
        if(((Byo) item).getType()!=null) {
            ((MaterialIconView) view.findViewById(R.id.byo_display_icon)).setIcon(getIcon(((Byo) item).getType()));
        }
    }

    private MaterialDrawableBuilder.IconValue getIcon(ByoType type){
        switch (type){
            case activity:
                return MaterialDrawableBuilder.IconValue.RUN;
            case service:
                return MaterialDrawableBuilder.IconValue.ALERT;
            case venue:
                return MaterialDrawableBuilder.IconValue.HOME;

        }
        return MaterialDrawableBuilder.IconValue.CURSOR_DEFAULT;
    }


}
