package com.example.byo.Types;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CurrentUser {
    private static FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public static String getEmail(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        return currentUser.getEmail();
    }

    public static FirebaseUser getUser(){
        return mAuth.getCurrentUser();
    }
}
