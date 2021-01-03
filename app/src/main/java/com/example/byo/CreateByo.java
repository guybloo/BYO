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

public class CreateByo extends AppCompatActivity {

    private Byo byo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_byo);

//        ((EditText) findViewById(R.id.byo_venue_address)).setVisibility(View.GONE);

        String[] typeSpinner = new String[]{"מקום", "פעילות", "שירות"};
        Spinner s = (Spinner) findViewById(R.id.byo_type_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typeSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) { // 0 == venue
                    ((EditText) findViewById(R.id.byo_venue_address)).setVisibility(View.VISIBLE);
                    ((TextView) findViewById(R.id.byo_venue_address_text)).setVisibility(View.VISIBLE);
                } else {
                    ((EditText) findViewById(R.id.byo_venue_address)).setVisibility(View.GONE);
                    ((TextView) findViewById(R.id.byo_venue_address_text)).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((EditText) findViewById(R.id.byo_venue_address)).setVisibility(View.VISIBLE);
            }
        });

//        switch (position)
        String[] subTypeSpinner = new String[]{"מקום", "פעילות", "שירות"};
        Spinner sub = (Spinner) findViewById(R.id.byo_subtype_spinner);
        ArrayAdapter<String> sub_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typeSpinner);
        sub_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sub.setAdapter(sub_adapter);

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

