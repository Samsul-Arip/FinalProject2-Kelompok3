package com.samsul.finalproject2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.samsul.finalproject2.data.constant.Constant;
import com.samsul.finalproject2.data.preferences.LocalPreferences;
import com.samsul.finalproject2.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LocalPreferences localPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        localPreferences = new LocalPreferences(this);

        binding.btnMasuk.setOnClickListener(v -> {
            String email = binding.edtEmail.getText().toString();
            String password = binding.edtPassword.getText().toString();
            if(email.equals("admin") && password.equals("admin")) {
                localPreferences.getEditor().putBoolean(Constant.PREFS_LOGIN, true);
                localPreferences.getEditor().apply();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else if(email.isEmpty() && password.isEmpty()) {
                binding.edtEmail.setError("Tidak boleh kosong");
                binding.edtPassword.setError("Tidak boleh kosong");
            } else {
                Toast.makeText(LoginActivity.this, "Password atau Username salah", Toast.LENGTH_SHORT).show();
            }

        });
    }
}