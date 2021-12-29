package com.samsul.aplikasiuser.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.samsul.aplikasiuser.data.Constant.Constant;
import com.samsul.aplikasiuser.data.preferences.LocalPreferences;
import com.samsul.aplikasiuser.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    private LocalPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = new LocalPreferences(this);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            boolean isLogin = preferences.getSharedPreferences().getBoolean(Constant.PREFS_LOGIN, false);
            Intent intent;
            if(isLogin) {
                intent = new Intent(SplashActivity.this, MainActivity.class);
            } else {
                intent = new Intent(SplashActivity.this, LoginActivity.class);
            }
            startActivity(intent);
            finish();

        },2000);

    }
}