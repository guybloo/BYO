package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.byo.DB.ByoDB;
import com.example.byo.Enums.Activities;
import com.example.byo.Enums.ByoType;
import com.example.byo.Enums.Services;
import com.example.byo.Enums.Venues;
import com.example.byo.Types.Byo;
import com.example.byo.Types.CurrentUser;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateByo extends AppCompatActivity {

    private Byo byo;
    Spinner typeSpinner, subTypeSpinner;
    ArrayList<String> parent_list, venue_list, activity_list, service_list;
    ArrayAdapter<String> parent_array_adapter, child_array_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_byo);

        typeSpinner = (Spinner) findViewById(R.id.byo_type_spinner);
        subTypeSpinner = (Spinner) findViewById(R.id.byo_subtype_spinner);

        parent_list = new ArrayList<>();
        for (ByoType b : ByoType.values()) {
            parent_list.add(b.name());
        }
//        parent_list.add("מקום");
//        parent_list.add("פעילות");
//        parent_list.add("שירות");

        parent_array_adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, parent_list);

        typeSpinner.setAdapter(parent_array_adapter);

        venue_list = new ArrayList<>();
        for (Venues v : Venues.values()) {
            venue_list.add(v.name());
        }
//        venue_list.add("בפנים");
//        venue_list.add("גג");
//        venue_list.add("חצר");
//        venue_list.add("מרפסת");

        activity_list = new ArrayList<>();
//        activity_list.add("מוזיקה");
//        activity_list.add("ספורט");
//        activity_list.add("הרצאה");
//        activity_list.add("סדנה");
//        activity_list.add("הופעה");
//        activity_list.add("תערוכה");
        for (Activities a : Activities.values()) {
            activity_list.add(a.name());
        }

        service_list = new ArrayList<>();
        for (Services s : Services.values()) {
            service_list.add(s.name());
        }
//        service_list.add("קייטרינג");
//        service_list.add("ציוד");

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ((EditText) findViewById(R.id.byo_venue_address)).setVisibility(View.VISIBLE);
                        ((TextView) findViewById(R.id.byo_venue_address_text)).setVisibility(View.VISIBLE);
                        child_array_adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, venue_list);
                        break;
                    case 1:
                        ((EditText) findViewById(R.id.byo_venue_address)).setVisibility(View.GONE);
                        ((TextView) findViewById(R.id.byo_venue_address_text)).setVisibility(View.GONE);
                        child_array_adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, activity_list);
                        break;
                    case 2:
                        ((EditText) findViewById(R.id.byo_venue_address)).setVisibility(View.GONE);
                        ((TextView) findViewById(R.id.byo_venue_address_text)).setVisibility(View.GONE);
                        child_array_adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, service_list);
                        break;
                }
                subTypeSpinner.setAdapter(child_array_adapter);
                if(Arrays.asList(ByoType.values()).indexOf(byo.getType()) == position) {
                    updateSubType();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        byo = (Byo) getIntent().getSerializableExtra(Byo.SER_LABEL);
        if (byo == null) {
            byo = new Byo();
            byo.setUserID(CurrentUser.getEmail());
        } else {
            loadByoDetails();
        }

        findViewById(R.id.btn_save_byos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateByo();
                (new ByoDB()).updateItem(byo);
                finish();
            }
        });

        findViewById(R.id.btn_delete_byos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new ByoDB()).removeItem(byo.getId());
                finish();
            }
        });

        ((SeekBar) findViewById(R.id.byo_price)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ((TextView) findViewById(R.id.create_byo_price_text)).setText(String.valueOf(((SeekBar) findViewById(R.id.byo_price)).getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ((SeekBar) findViewById(R.id.byo_max_part)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ((TextView) findViewById(R.id.create_byo_max_text)).setText(String.valueOf(((SeekBar) findViewById(R.id.byo_max_part)).getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

//    private void configureUI() {
//    }

    private void loadByoDetails() {
        ((EditText) findViewById(R.id.byo_title_text)).setText(byo.getTitle());
        ((EditText) findViewById(R.id.byo_description_text)).setText(byo.getDescription());
        ((SeekBar) findViewById(R.id.byo_max_part)).setProgress(byo.getMaxParticipants());
        ((SeekBar) findViewById(R.id.byo_price)).setProgress(byo.getPrice());
        ((TextView) findViewById(R.id.create_byo_max_text)).setText(String.valueOf(byo.getMaxParticipants()));
        ((TextView) findViewById(R.id.create_byo_price_text)).setText(String.valueOf(byo.getPrice()));
        ((TextView) findViewById(R.id.byo_venue_address)).setText(String.valueOf(byo.getAddress()));
        typeSpinner.setSelection(Arrays.asList(ByoType.values()).indexOf(byo.getType()));

    }

    private void updateSubType(){
        int index = 0;
        switch (byo.getType()) {
            case מקום:
                index = Arrays.asList(Venues.values()).indexOf(Venues.valueOf(byo.getSubType()));
                break;
            case פעילות:
                index = Arrays.asList(Activities.values()).indexOf(Activities.valueOf(byo.getSubType()));
                break;
            case שירות:
                index = Arrays.asList(Services.values()).indexOf(Services.valueOf(byo.getSubType()));
                break;
        }
        subTypeSpinner.setSelection(index);
    }

    private void updateByo() {
        byo.setTitle(((EditText) findViewById(R.id.byo_title_text)).getText().toString());

        String typeText = ((Spinner) findViewById(R.id.byo_type_spinner)).getSelectedItem().toString();
//        ByoType type = textToEnum(typeText);
        byo.setType(ByoType.valueOf(typeText));

        String subTypeText = ((Spinner) findViewById(R.id.byo_subtype_spinner)).getSelectedItem().toString();
//        updateSubType(type, subTypeText);
        byo.setSubType(subTypeText);

        byo.setMaxParticipants(((SeekBar) findViewById(R.id.byo_max_part)).getProgress());

        byo.setPrice(((SeekBar) findViewById(R.id.byo_price)).getProgress());

        byo.setDescription(((EditText) findViewById(R.id.byo_description_text)).getText().toString());
        byo.setAddress(((EditText) findViewById(R.id.byo_venue_address)).getText().toString());


        // TODO - social media

    }

//    private ByoType textToEnum(String text) {
//        switch (text) {
//            case "מקום":
//                return ByoType.מקום;
//            case "פעילות":
//                return ByoType.פעילות;
//            case "שירות":
//                return ByoType.שירות;
//        }
//        return null;
//    }
//
//    private void updateSubType(ByoType type, String subTypeText) {
//        switch (type) {
//            case מקום:
//                switch (subTypeText) {
//                    case "בפנים":
//                        byo.setSubType(Venues.בפנים.name());
//                        break;
//                    case "גג":
//                        byo.setSubType(Venues.גג.name());
//                        break;
//                    case "חצר":
//                        byo.setSubType(Venues.גינה.name());
//                        break;
//                    case "מרפסת":
//                        byo.setSubType(Venues.מרפסת.name());
//                        break;
//                }
//                break;
//            case שירות:
//                switch (subTypeText) {
//                    case "קייטרינג":
//                        byo.setSubType(Services.קייטרינג.name());
//                        break;
//                    case "ציוד":
//                        byo.setSubType(Services.ציוד.name());
//                        break;
//                }
//                break;
//            case פעילות:
//                switch (subTypeText) {
//                    case "מוזיקה":
//                        byo.setSubType(Activities.מוזיקה.name());
//                        break;
//                    case "ספורט":
//                        byo.setSubType(Activities.ספורט.name());
//                        break;
//                    case "הרצאה":
//                        byo.setSubType(Activities.הרצאה.name());
//                        break;
//                    case "סדנה":
//                        byo.setSubType(Activities.סדנה.name());
//                        break;
//                    case "הופעה":
//                        byo.setSubType(Activities.הופעה.name());
//                        break;
//                    case "תערוכה":
//                        byo.setSubType(Activities.תערוכה.name());
//                        break;
//                }
//                break;
//        }
//    }
}

