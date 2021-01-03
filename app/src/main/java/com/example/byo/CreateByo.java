package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.byo.Enums.ByoType;
import com.example.byo.Types.Byo;

import java.util.ArrayList;

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
        parent_list.add("מקום");
        parent_list.add("פעילות");
        parent_list.add("שירות");

        parent_array_adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, parent_list);

        typeSpinner.setAdapter(parent_array_adapter);

        venue_list = new ArrayList<>();
        venue_list.add("בפנים");
        venue_list.add("גג");
        venue_list.add("חצר");
        venue_list.add("מרפסת");

        activity_list = new ArrayList<>();
        activity_list.add("מוזיקה");
        activity_list.add("ספורט");
        activity_list.add("הרצאה");
        activity_list.add("סדנה");
        activity_list.add("הופעה");
        activity_list.add("תערוכה");

        service_list = new ArrayList<>();
        service_list.add("קייטרינג");
        service_list.add("ציוד");

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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        byo = (Byo) getIntent().getSerializableExtra(Byo.SER_LABEL);
        if (byo == null) {
            byo = new Byo();
        }
    }

//    private void configureUI() {
//    }


    private void updateByo() {
        byo.setTitle(((EditText) findViewById(R.id.byo_title_text)).getText().toString());

        String typeText = ((Spinner) findViewById(R.id.byo_type_spinner)).getSelectedItem().toString();
        ByoType type = textToEnum(typeText);
        byo.setType(type);

        String subTypeText = ((Spinner) findViewById(R.id.byo_subtype_spinner)).getSelectedItem().toString();
        updateSubType(type, subTypeText);

        byo.setMaxParticipants(((SeekBar) findViewById(R.id.byo_max_part)).getProgress());

        byo.setPrice(((SeekBar) findViewById(R.id.byo_price)).getProgress());

        byo.setDescription(((EditText) findViewById(R.id.byo_description_text)).getText().toString());


        // TODO - social media

    }

    private ByoType textToEnum(String text) {
        switch (text) {
            case "מקום":
                return ByoType.venue;
            case "פעילות":
                return ByoType.activity;
            case "שירות":
                return ByoType.service;
        }
        return null;
    }

    private void updateSubType(ByoType type, String subTypeText) {
        switch (type) {
            case venue:
                switch (subTypeText) {
                    case "בפנים":
                        byo.setSubType(1);
                        break;
                    case "גג":
                        byo.setSubType(2);
                        break;
                    case "חצר":
                        byo.setSubType(3);
                        break;
                    case "מרפסת":
                        byo.setSubType(4);
                        break;
                }
                break;
            case service:
                switch (subTypeText) {
                    case "קייטרינג":
                        byo.setSubType(1);
                        break;
                    case "ציוד":
                        byo.setSubType(2);
                        break;
                }
                break;
            case activity:
                switch (subTypeText) {
                    case "מוזיקה":
                        byo.setSubType(1);
                        break;
                    case "ספורט":
                        byo.setSubType(2);
                        break;
                    case "הרצאה":
                        byo.setSubType(3);
                        break;
                    case "סדנה":
                        byo.setSubType(4);
                        break;
                    case "הופעה":
                        byo.setSubType(5);
                        break;
                    case "תערוכה":
                        byo.setSubType(6);
                        break;
                }
                break;
        }
    }
}

