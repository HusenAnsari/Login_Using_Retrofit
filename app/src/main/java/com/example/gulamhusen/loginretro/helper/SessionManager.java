package com.example.gulamhusen.loginretro.helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.gulamhusen.loginretro.api.model.User;
import com.example.gulamhusen.loginretro.ui.LoginActivity;

import java.util.HashMap;

/**
 * Created by gulamhusen on 11-04-2017.
 */

public class SessionManager {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    Context context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LoginRetro";

    private static final String IS_LOGIN = "IsLoggedIn";
    private static String USER_KEY = "user_key";


    public SessionManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    }

    /*public static SharedPreferences getPrefs(Context context){
        preferences = context.getSharedPreferences(PREF_NAME, 0);
        return preferences;
    }*/

    public void setUserLogin() {
        editor = preferences.edit();
        editor.putBoolean(IS_LOGIN, true);
        editor.commit();
    }

    public boolean isUserLogIn() {
        return preferences.getBoolean(IS_LOGIN, false);
    }

    public void setUserData(User userData) {
        editor = preferences.edit();
        String userToStr=Function.getJsonToStr(userData);
        editor.putString(USER_KEY,userToStr);
        editor.commit();
    }

    public User getUserData(){
        return MyApplication.getGson().fromJson(preferences.getString(USER_KEY,""),User.class);
    }

    public void logOut() {
        editor=preferences.edit();
        editor.clear();
        editor.commit();
    }
}
