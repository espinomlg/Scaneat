package com.example.espino.scaneat.singletons;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by espino on 2/12/16.
 */

public class MyPreferences {
    private static final String PREFERENCES_FILES = "UserAccount";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String PASSWD = "passwd";
    public static final String ERROR = "error";

    private static MyPreferences instance;
    private SharedPreferences preferences;
    private Context context;

    private MyPreferences(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_FILES, Context.MODE_PRIVATE);
    }

    public static MyPreferences getInstance(Context context){
        if(instance == null)
            instance = new MyPreferences(context);

        return instance;
    }

    private SharedPreferences.Editor editor(){
        return preferences.edit();
    }

    public boolean putString(String key, String value){

        if(editor().putString(key, value).commit())
            return true;

        return false;
    }

    public String getString(String key){
        return preferences.getString(key, ERROR);
    }


}
