package com.example.l6_mynotes.utils;

import android.content.Context;

import com.example.l6_mynotes.App;

public class ContextUtils {
    public static App getApp(Context context){
        return (App) context.getApplicationContext();
    }
}
