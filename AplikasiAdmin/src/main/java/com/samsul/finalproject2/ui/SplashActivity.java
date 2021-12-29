package com.samsul.finalproject2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.samsul.finalproject2.data.constant.Constant;
import com.samsul.finalproject2.data.preferences.LocalPreferences;
import com.samsul.finalproject2.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    private LocalPreferences localPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        localPreferences = new LocalPreferences(this);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            boolean isLogin = localPreferences.getSharedPreferences().getBoolean(Constant.PREFS_LOGIN, false);
            Intent intent;

            if(isLogin) {
                intent = new Intent(SplashActivity.this, MainActivity.class);
            } else {
                intent = new Intent(SplashActivity.this, LoginActivity.class);
            }
            startActivity(intent);
            SplashActivity.this.finish();

        },2000);
    }
}