package com.samsul.aplikasiuser.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalPreferences {

    private final SharedPreferences sharedPreferences;

    private final SharedPreferences.Editor editor;

    public LocalPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("samplePref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }
}
