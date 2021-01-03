package com.example.byo.Displays;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.byo.Enums.Activities;
import com.example.byo.Enums.ByoType;
import com.example.byo.Enums.Services;
import com.example.byo.Enums.Venues;
import com.example.byo.Navigation;
import com.example.byo.R;
import com.example.byo.Types.Byo;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;
import net.steamcrafted.materialiconlib.MaterialIconView;

/**
 * shows user details in group
 */
public class ByoDisplay extends GenericDisplay {

    public ByoDisplay(Byo byo, final Context context) {
        super(byo, context, R.layout.byo_display);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.openCreateByo(context, (Byo) item);
            }
        });

    }

    @Override
    public void updateUI() {
        super.updateUI();
        ((TextView) view.findViewById(R.id.byo_display_title)).setText(((Byo) item).getTitle());
        if (((Byo) item).getType() != null) {
            ((MaterialIconView) view.findViewById(R.id.byo_display_icon)).setIcon(getTypeIcon(((Byo) item).getType()));
        }
        if (!((Byo) item).getSubType().equals("")) {
            switch (((Byo) item).getType()){
                case activity:
                    ((MaterialIconView) view.findViewById(R.id.byo_display_icon_sub)).setIcon(getSubActivityIcon(Activities.valueOf(((Byo) item).getSubType())));
                    break;
                case service:
                    ((MaterialIconView) view.findViewById(R.id.byo_display_icon_sub)).setIcon(getSubServicesIcon(Services.valueOf(((Byo) item).getSubType())));
                    break;
                case venue:
                    ((MaterialIconView) view.findViewById(R.id.byo_display_icon_sub)).setIcon(getSubVenuesIcon(Venues.valueOf(((Byo) item).getSubType())));
                    break;

            }
        }
    }

    private MaterialDrawableBuilder.IconValue getTypeIcon(ByoType type) {
        switch (type) {
            case activity:
                return MaterialDrawableBuilder.IconValue.ACCOUNT;
            case service:
                return MaterialDrawableBuilder.IconValue.BRIEFCASE;
            case venue:
                return MaterialDrawableBuilder.IconValue.MAP_MARKER;

        }
        return MaterialDrawableBuilder.IconValue.HELP;
    }

    private MaterialDrawableBuilder.IconValue getSubActivityIcon(Activities type) {
        switch (type) {
            case exhibition:
                return MaterialDrawableBuilder.IconValue.PALETTE;
            case musician:
                return MaterialDrawableBuilder.IconValue.MUSIC;

            case sport:
                return MaterialDrawableBuilder.IconValue.RUN;

            case lecture:
                return MaterialDrawableBuilder.IconValue.VOICE;

            case workshop:
                return MaterialDrawableBuilder.IconValue.HAMMER;

            case performance:
                return MaterialDrawableBuilder.IconValue.THEATER;
        }
        return MaterialDrawableBuilder.IconValue.HELP;
    }
    private MaterialDrawableBuilder.IconValue getSubServicesIcon(Services type) {
        switch (type) {
            case catering:
                return MaterialDrawableBuilder.IconValue.FOOD;
            case equipment:
                return MaterialDrawableBuilder.IconValue.ATTACHMENT;

        }
        return MaterialDrawableBuilder.IconValue.HELP;
    }
    private MaterialDrawableBuilder.IconValue getSubVenuesIcon(Venues type) {
        switch (type) {
            case indoors:
                return MaterialDrawableBuilder.IconValue.SOFA;
            case roof:
                return MaterialDrawableBuilder.IconValue.HOME_LOCK;

            case garden:
                return MaterialDrawableBuilder.IconValue.NATURE;

            case balcony:
                return MaterialDrawableBuilder.IconValue.HOME;

        }
        return MaterialDrawableBuilder.IconValue.HELP;
    }
}
