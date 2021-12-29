package com.samsul.aplikasiuser.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.samsul.aplikasiuser.data.Constant.Constant;
import com.samsul.aplikasiuser.data.preferences.LocalPreferences;
import com.samsul.aplikasiuser.databinding.ActivityLoginBinding;
import com.samsul.aplikasiuser.presenter.LoginPresenter;
import com.samsul.aplikasiuser.repository.LoginContract;

public class LoginActivity extends AppCompatActivity implements LoginContract.MainView {

    private ActivityLoginBinding binding;
    private LoginPresenter presenter;
    private LocalPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new LoginPresenter(this);
        preferences = new LocalPreferences(this);

    }

    @Override
    public void onCreateActivity() {
        binding.tvSignUp.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        binding.btnMasuk.setOnClickListener(v -> {
            String noPhone = binding.edtNoHp.getText().toString();
            String password = binding.edtPassword.getText().toString();
            if(noPhone.isEmpty() && password.isEmpty()) {
                binding.edtNoHp.setError("Tidak boleh kosong");
                binding.edtPassword.setError("Tidak boleh kosong");
            } else {
                presenter.loginUser(noPhone, password);
            }
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(Boolean loading) {
        if(loading) {
            binding.pbLoading.setVisibility(View.VISIBLE);
            binding.btnMasuk.setVisibility(View.GONE);
        } else {
            binding.pbLoading.setVisibility(View.GONE);
            binding.btnMasuk.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void nextActivity() {
        preferences.getEditor().putBoolean(Constant.PREFS_LOGIN, true);
        preferences.getEditor().apply();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}