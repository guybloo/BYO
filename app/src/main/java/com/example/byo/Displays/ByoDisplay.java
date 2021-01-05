package com.example.byo.Displays;

import android.content.Context;
import android.view.View;

import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.byo.DB.DBItem;
import com.example.byo.DB.DBWrapper;
import com.example.byo.DB.RateDB;
import com.example.byo.Enums.Activities;
import com.example.byo.Enums.ByoType;
import com.example.byo.Enums.Services;
import com.example.byo.Enums.Venues;
import com.example.byo.Navigation;
import com.example.byo.R;
import com.example.byo.Types.Byo;
import com.example.byo.Types.Rate;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;
import net.steamcrafted.materialiconlib.MaterialIconView;

/**
 * shows user details in group
 */
public class ByoDisplay extends GenericDisplay {

    public ByoDisplay(Byo byo, final Context context, final boolean edit, LinearLayout layout) {
        super(byo, context, R.layout.byo_display, layout);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.openCreateByo(context, (Byo) item, edit);
            }
        });

    }

    @Override
    public void updateUI() {
        super.updateUI();
        ((TextView) view.findViewById(R.id.byo_display_title)).setText(((Byo) item).getTitle());
        ((TextView) view.findViewById(R.id.byo_display_email)).setText(((Byo) item).getUserID());
        ((TextView) view.findViewById(R.id.byo_display_id)).setText(((Byo) item).getId());
        if (((Byo) item).getType() != null) {
            ((MaterialIconView) view.findViewById(R.id.byo_display_icon)).setIcon(getTypeIcon(((Byo) item).getType()));
        }
        if (!((Byo) item).getSubType().equals("")) {
            switch (((Byo) item).getType()){
                case פעילות:
                    ((MaterialIconView) view.findViewById(R.id.byo_display_icon_sub)).setIcon(getSubActivityIcon(Activities.valueOf(((Byo) item).getSubType())));
                    break;
                case שירות:
                    ((MaterialIconView) view.findViewById(R.id.byo_display_icon_sub)).setIcon(getSubServicesIcon(Services.valueOf(((Byo) item).getSubType())));
                    break;
                case מקום:
                    ((MaterialIconView) view.findViewById(R.id.byo_display_icon_sub)).setIcon(getSubVenuesIcon(Venues.valueOf(((Byo) item).getSubType())));
                    break;

            }
        }
        updateRate();

    }

    private MaterialDrawableBuilder.IconValue getTypeIcon(ByoType type) {
        switch (type) {
            case פעילות:
                return MaterialDrawableBuilder.IconValue.ACCOUNT;
            case שירות:
                return MaterialDrawableBuilder.IconValue.BRIEFCASE;
            case מקום:
                return MaterialDrawableBuilder.IconValue.MAP_MARKER;

        }
        return MaterialDrawableBuilder.IconValue.HELP;
    }

    private MaterialDrawableBuilder.IconValue getSubActivityIcon(Activities type) {
        switch (type) {
            case תערוכה:
                return MaterialDrawableBuilder.IconValue.PALETTE;
            case מוזיקה:
                return MaterialDrawableBuilder.IconValue.MUSIC;

            case ספורט:
                return MaterialDrawableBuilder.IconValue.RUN;

            case הרצאה:
                return MaterialDrawableBuilder.IconValue.VOICE;

            case סדנה:
                return MaterialDrawableBuilder.IconValue.HAMMER;

            case הופעה:
                return MaterialDrawableBuilder.IconValue.THEATER;
        }
        return MaterialDrawableBuilder.IconValue.HELP;
    }
    private MaterialDrawableBuilder.IconValue getSubServicesIcon(Services type) {
        switch (type) {
            case קייטרינג:
                return MaterialDrawableBuilder.IconValue.FOOD;
            case ציוד:
                return MaterialDrawableBuilder.IconValue.ATTACHMENT;

        }
        return MaterialDrawableBuilder.IconValue.HELP;
    }
    private MaterialDrawableBuilder.IconValue getSubVenuesIcon(Venues type) {
        switch (type) {
            case בפנים:
                return MaterialDrawableBuilder.IconValue.SOFA;
            case גג:
                return MaterialDrawableBuilder.IconValue.HOME_LOCK;

            case גינה:
                return MaterialDrawableBuilder.IconValue.NATURE;

            case מרפסת:
                return MaterialDrawableBuilder.IconValue.HOME;

        }
        return MaterialDrawableBuilder.IconValue.HELP;
    }

    private void updateRate()
    {
        final RateDB rateDB = new RateDB();
        rateDB.loadItemsByFieldFromDB(RateDB.RATED_ID, item.getId());
        rateDB.setDataChangeListener(new DBWrapper.OnDataChangeListener() {
            @Override
            public void onGetAll() {
            }

            @Override
            public void onGetSpecific() {
                float sum = 0, num = 0;
                for(DBItem it : rateDB.getItems().values()){
                    num ++;
                    sum += ((Rate)it).getStars();
                }
                ((RatingBar)view.findViewById(R.id.byo_display_rate)).setRating(sum / num);
            }
        });

    }
}
