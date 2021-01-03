package com.example.byo;

import android.content.Context;
import android.content.Intent;

import com.example.byo.Types.Byo;

public class Navigation {
    public static void openRegistration(Context context){
        Intent intent = new Intent(context, Registration.class);
        context.startActivity(intent);
    }
    public static void openUserMenu(Context context){
        Intent intent = new Intent(context, UserMenu.class);
        context.startActivity(intent);
    }

    public static void openManageByos(Context context){
        Intent intent = new Intent(context, ManageByos.class);
        context.startActivity(intent);
    }

    public static void openManageEvents(Context context){
        Intent intent = new Intent(context, ManageEvents.class);
        context.startActivity(intent);
    }

    public static void openCreateByo(Context context, Byo byo){
        Intent intent = new Intent(context, CreateByo.class);
        intent.putExtra(Byo.SER_LABEL, byo);
        context.startActivity(intent);
    }

}
