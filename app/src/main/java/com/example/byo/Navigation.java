package com.example.byo;

import android.content.Context;
import android.content.Intent;

import com.example.byo.Types.Byo;
import com.example.byo.Types.Event;

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

    public static void openCreateByo(Context context, Byo byo, boolean edit){
        Intent intent = new Intent(context, CreateByo.class);
        intent.putExtra(Byo.SER_LABEL, byo);
        intent.putExtra(CreateByo.EDIT, edit);
        context.startActivity(intent);
    }

 public static void openCreateEvent(Context context, Event event){
        Intent intent = new Intent(context, CreateEvent.class);
        intent.putExtra(Event.SER_LABEL, event);
        context.startActivity(intent);
    }

    public static void openByoChoose(Context context, Event eventId){
        Intent intent = new Intent(context, ByoChoose.class);
        intent.putExtra(ByoChoose.EVENT, eventId);
        context.startActivity(intent);
    }
}
