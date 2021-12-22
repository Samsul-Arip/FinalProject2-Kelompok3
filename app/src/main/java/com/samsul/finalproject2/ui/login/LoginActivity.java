package com.samsul.finalproject2.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.samsul.finalproject2.databinding.ActivityLoginBinding;
import com.samsul.finalproject2.ui.home.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnMasuk.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}