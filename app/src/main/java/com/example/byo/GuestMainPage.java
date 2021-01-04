package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class GuestMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_main_page);

        // check if intent is from external link
        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

    }
}