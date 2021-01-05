package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.byo.DB.ByoDB;
import com.example.byo.DB.DBItem;
import com.example.byo.DB.DBWrapper;
import com.example.byo.DB.EventDB;
import com.example.byo.DB.RateDB;
import com.example.byo.Enums.ByoType;
import com.example.byo.Types.Byo;
import com.example.byo.Types.CurrentUser;
import com.example.byo.Types.Event;
import com.example.byo.Types.Rate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;

//        Rate r = new Rate("0","guy@b.com_1609714064525",5,"");
//        Rate rr = new Rate("0","guy@b.com_1609714064525",3,"");
//        (new RateDB()).updateItem(r);
//        (new RateDB()).updateItem(rr);
        findViewById(R.id.registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.openRegistration(context);
            }
        });
        findViewById(R.id.main_events).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.openAllEvents(context);
            }
        });
//        final ByoDB byoDB = new ByoDB();
//        byoDB.getAllItems();
//        byoDB.setDataChangeListener(new DBWrapper.OnDataChangeListener() {
//            @Override
//            public void onGetAll() {
//                for(DBItem item : byoDB.getItems().values()){
//                    Random rand = new Random();
//                    Rate rate = new Rate();
//                    rate.setStars(rand.nextInt(5) + 1);
//                    rate.setRatedID(item.getId());
//                    (new RateDB()).updateItem(rate);
//                }
//            }
//
//            @Override
//            public void onGetSpecific() {
//
//            }
//        });
    }
}