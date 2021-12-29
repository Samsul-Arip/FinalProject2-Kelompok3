package com.samsul.aplikasi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.samsul.aplikasi.R;
import com.samsul.aplikasi.databinding.ActivityLoginBinding;
import com.samsul.aplikasi.presenter.LoginPresenter;
import com.samsul.aplikasi.respository.LoginContract;

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
        binding.btnMasuk.setOnClickListener(v -> {
            String username = binding.edtEmail.getText().toString().trim();
            String password = binding.edtPassword.getText().toString().trim();
            if(username.isEmpty() && password.isEmpty()) {
                binding.edtEmail.setError("Tidak boleh kosong");
                binding.edtPassword.setError("Tidak boleh kosong");
            } else {
                presenter.loginStaf(username, password);
            }

        });
    }

    @Override
    public void showLoading(Boolean loading) {
        if(loading) {
            binding.pbLoading.setVisibility(View.VISIBLE);
            binding.btnMasuk.setVisibility(View.GONE);
        }  else {
            binding.pbLoading.setVisibility(View.GONE);
            binding.btnMasuk.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nextActivity() {
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
    }
}