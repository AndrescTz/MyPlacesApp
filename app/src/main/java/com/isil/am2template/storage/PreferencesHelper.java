package com.isil.am2template.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by AndresCyTz on 24/11/2017.
 */

public class PreferencesHelper {
    private static final String MYPLACES_PREFERENCES = "MYPLACESPreferences";
    private static final String PREFERENCES_MAIL = MYPLACES_PREFERENCES + ".mail";
    private static final String PREFERENCES_PASSWORD = MYPLACES_PREFERENCES + ".password";
    private static final String PREFERENCES_TOKEN = MYPLACES_PREFERENCES + ".token";

    private PreferencesHelper() {
        //no instance
    }

    public static void signOut(Context context) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.remove(PREFERENCES_MAIL);
        editor.remove(PREFERENCES_PASSWORD);
        editor.apply();
    }

    public static void saveSession(Context context,String mail,String token)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCES_MAIL, mail);
        editor.putString(PREFERENCES_TOKEN, token);
        editor.apply();
    }

    public static String getUserSession(Context context)
    {
        SharedPreferences sharedPreferences= getSharedPreferences(context);
        String mail= sharedPreferences.getString(PREFERENCES_MAIL,null);

        return mail;
    }

    public static String getTokenSession(Context context)
    {
        SharedPreferences sharedPreferences= getSharedPreferences(context);
        String token= sharedPreferences.getString(PREFERENCES_TOKEN,null);

        return token;
    }

    public static boolean isSignedIn(Context context) {
        final SharedPreferences preferences = getSharedPreferences(context);
        return preferences.contains(PREFERENCES_MAIL);
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(MYPLACES_PREFERENCES, Context.MODE_PRIVATE);
    }    
}
