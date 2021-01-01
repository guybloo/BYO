package com.example.byo;

import android.content.Context;
import android.content.Intent;

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

}
