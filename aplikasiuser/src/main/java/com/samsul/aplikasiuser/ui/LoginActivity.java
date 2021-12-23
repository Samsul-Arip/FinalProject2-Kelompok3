package com.samsul.aplikasiuser.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.samsul.aplikasiuser.databinding.ActivityLoginBinding;
import com.samsul.aplikasiuser.presenter.LoginPresenter;
import com.samsul.aplikasiuser.repository.LoginContract;

public class LoginActivity extends AppCompatActivity implements LoginContract.MainView {

    private ActivityLoginBinding binding;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new LoginPresenter(this);


    }

    @Override
    public void onCreateActivity() {
        binding.tvSignUp.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        binding.btnMasuk.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
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
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}