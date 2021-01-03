package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.byo.DB.ByoDB;
import com.example.byo.DB.DBItem;
import com.example.byo.DB.DBWrapper;
import com.example.byo.DB.EventDB;
import com.example.byo.Displays.ByoDisplay;
import com.example.byo.Types.Byo;
import com.example.byo.Types.CurrentUser;
import com.example.byo.Types.Event;

import java.util.ArrayList;
import java.util.List;

public class ManageByos extends AppCompatActivity {

    private List<Byo> items;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_byos);

        layout = findViewById(R.id.layout_manage_byos);
        items = new ArrayList<>();
        final Context context = this;

        findViewById(R.id.btn_add_byo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.openCreateByo(context,null);
            }
        });
        loadByos();
    }

    private void loadByos() {
        final ByoDB db = new ByoDB();
        db.loadItemsByFieldFromDB(ByoDB.USER_ID, CurrentUser.getEmail());
        db.setDataChangeListener(new DBWrapper.OnDataChangeListener() {
            @Override
            public void onGetAll() {

            }

            @Override
            public void onGetSpecific() {
                items.clear();
                for (DBItem item : db.getItems().values()) {
                    items.add((Byo) item);
                }
                updateByos();
            }
        });
    }

    private void updateByos() {
        layout.removeAllViews();

        for (Byo item : items) {
            ByoDisplay display = new ByoDisplay(item, this);
            display.addView(layout);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadByos();
    }
}