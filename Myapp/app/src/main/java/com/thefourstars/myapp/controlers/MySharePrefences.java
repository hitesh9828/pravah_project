package com.thefourstars.myapp.controlers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Duggu on 03-Nov-15.
 */
public class MySharePrefences {
    private static MySharePrefences instance;
    private Context context;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    public MySharePrefences(Context context) {
        this.context = context;
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }
    public static MySharePrefences getInstance(Context context){
        if( instance == null){
            instance = new MySharePrefences(context);
        }
        return instance;
    }
    public void setLoginFlag(boolean flag){

    }
}
