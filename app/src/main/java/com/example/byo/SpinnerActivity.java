package com.example.byo;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

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
