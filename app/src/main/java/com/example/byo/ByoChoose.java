package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.byo.DB.ByoDB;
import com.example.byo.DB.DBItem;
import com.example.byo.DB.DBWrapper;
import com.example.byo.Displays.ByoDisplay;
import com.example.byo.Enums.Activities;
import com.example.byo.Enums.ByoType;
import com.example.byo.Enums.Services;
import com.example.byo.Enums.Venues;
import com.example.byo.Types.Byo;
import com.example.byo.Types.CurrentUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByoChoose extends AppCompatActivity {
    private Spinner typeSpinner, subTypeSpinner;
    private ArrayList<String> parent_list, venue_list, activity_list, service_list;
    private ArrayAdapter<String> parent_array_adapter, child_array_adapter;
    private List<Byo> myItems;
    private List<Byo> items;
    private ByoDB db;
    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_byo_choose);

        db = new ByoDB();
        items = new ArrayList<>();
        myItems = new ArrayList<>();
        typeSpinner = (Spinner) findViewById(R.id.choose_byo_type_spinner);
        subTypeSpinner = (Spinner) findViewById(R.id.choose_byo_subtype_spinner);
        layout = findViewById(R.id.choose_byo_layout);

        parent_list = new ArrayList<>();
        for (ByoType b : ByoType.values()) {
            parent_list.add(b.name());
        }

        parent_array_adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, parent_list);

        typeSpinner.setAdapter(parent_array_adapter);

        venue_list = new ArrayList<>();
        for (Venues v : Venues.values()) {
            venue_list.add(v.name());
        }

        activity_list = new ArrayList<>();
        for (Activities a : Activities.values()) {
            activity_list.add(a.name());
        }

        service_list = new ArrayList<>();
        for (Services s : Services.values()) {
            service_list.add(s.name());
        }

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        child_array_adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, venue_list);
                        break;
                    case 1:
                        child_array_adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, activity_list);
                        break;
                    case 2:
                        child_array_adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, service_list);
                        break;
                }
                subTypeSpinner.setAdapter(child_array_adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.choose_byo_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.loadItemsByFieldFromDB(ByoDB.SUB_TYPE,subTypeSpinner.getSelectedItem().toString());
                db.setDataChangeListener(new DBWrapper.OnDataChangeListener() {
                    @Override
                    public void onGetAll() {

                    }

                    @Override
                    public void onGetSpecific() {
                        items.clear();
                        myItems.clear();
                        String myEmail = CurrentUser.getEmail();
                        for(DBItem item : db.getItems().values()){
                            if(((Byo)item).getUserID().equals(myEmail)){
                                myItems.add((Byo)item);
                            }
                            else {
                                items.add((Byo) item);
                            }
                        }
                        updateByos();
                    }
                });
            }
        });
    }

    private void updateByos() {
        layout.removeAllViews();
        for (Byo item : myItems) {
            ByoDisplay display = new ByoDisplay(item, this);
            display.addView(layout);
        }
        for (Byo item : items) {
            ByoDisplay display = new ByoDisplay(item, this);
            display.addView(layout);
        }
    }
}