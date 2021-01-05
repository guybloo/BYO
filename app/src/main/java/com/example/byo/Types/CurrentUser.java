package com.example.byo.Types;

import android.net.Uri;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class CurrentUser {
    private static FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public static String getEmail(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        return currentUser.getEmail();
    }

    public static Uri getImage(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        return currentUser.getPhotoUrl();
    }
    public static void updateImage(Uri uri) {
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setPhotoUri(uri)
                .build();
        mAuth.getCurrentUser().updateProfile(profileUpdates);
    }


    public static FirebaseUser getUser(){
        return mAuth.getCurrentUser();
    }
}
