package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.byo.DB.ByoDB;
import com.example.byo.DB.EventDB;
import com.example.byo.Types.Byo;
import com.example.byo.Types.Event;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, Registration.class);
        this.startActivity(intent);
    }
}