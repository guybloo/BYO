package com.example.byo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.byo.DB.ImagesDB;
import com.example.byo.Types.CurrentUser;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;

public class UserMenu extends AppCompatActivity {

    private int PICK_IMAGE_REQUEST = 0;
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
        findViewById(R.id.btn_log_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });

        findViewById(R.id.menu_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        if(CurrentUser.getImage()!= null)
        {

                ImagesDB.showCircleImage(CurrentUser.getImage().toString(),(ImageView)findViewById(R.id.menu_image),this);

        }
    }
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    /**
     * update the user's imageUri after it chooses an image
     * @param requestCode - PICK_IMAGE_REQUEST
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            Uri uri = data.getData();
            if(uri == null){
                return;
            }

            if(uri!= null) {
                ImagesDB.Upload(uri);
            }
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver() , uri);
                ImagesDB.showCircleBitmapImage(bitmap,(ImageView)findViewById(R.id.menu_image),this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}