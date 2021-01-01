package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.byo.Enums.ByoType;
import com.example.byo.Types.Byo;

public class CreateByo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_byo);

        Byo byo = (Byo) getIntent().getSerializableExtra(Byo.SER_LABEL);
        if(byo == null)
        {
            byo = new Byo();
        }

    }
}