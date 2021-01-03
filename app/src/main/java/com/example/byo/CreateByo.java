package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        byo = (Byo) getIntent().getSerializableExtra(Byo.SER_LABEL);
        if (byo == null) {
            byo = new Byo();
        }
    }

    private void configureUI() {

        ((Spinner) findViewById(R.id.byo_type_spinner)).setOnItemClickListener(this);

    }


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

class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // if venue - show address textbox
        if (pos == 2) { // 2 == venue
            ((EditText) findViewById(R.id.byo_venue_address)).setVisibility(View.VISIBLE);
        } else {
            ((EditText) findViewById(R.id.byo_venue_address)).setVisibility(View.GONE);
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }
}