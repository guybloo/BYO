package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.byo.DB.ByoDB;
import com.example.byo.DB.EventDB;
import com.example.byo.Types.Byo;
import com.example.byo.Types.Event;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mAuth = FirebaseAuth.getInstance();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
        EventDB e = new EventDB();
        Event ev = new Event("1","a","a",1,1,"d","d", null);
        e.updateItem(ev);
    }
}