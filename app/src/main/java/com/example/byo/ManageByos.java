package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.byo.Displays.ByoDisplay;
import com.example.byo.Types.Byo;

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

        Byo b = new Byo();
        b.setTitle("first byo");
        Byo bb = new Byo();
        bb.setTitle("second byo");

        items.add(b);
        items.add(bb);

        updateByos();
    }

    private void updateByos(){
        layout.removeAllViews();

        for(Byo item : items){
            ByoDisplay display = new ByoDisplay(item, this);
            display.addView(layout);
        }
    }
}