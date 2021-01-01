package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class UserMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu2);
        final Context context = this;

        findViewById(R.id.btn_manage_byos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.openManageByos(context);
            }
        });
        findViewById(R.id.btn_manage_events).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.openManageEvents(context);
            }
        });
    }
}