package com.samsul.aplikasiuser.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.samsul.aplikasiuser.R;
import com.samsul.aplikasiuser.databinding.ActivityRegisterBinding;
import com.samsul.aplikasiuser.presenter.RegisterPresenter;
import com.samsul.aplikasiuser.repository.RegisterContract;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.MainView {

    private ActivityRegisterBinding binding;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new RegisterPresenter(this);
    }

    @Override
    public void onCreateActivity() {
        binding.btnRegister.setOnClickListener(v -> {
            String username = binding.edtName.getText().toString();
            String password = binding.edtPassword.getText().toString();
            String noPhone = binding.edtPhone.getText().toString();

            if(username.isEmpty() && password.isEmpty() && noPhone.isEmpty()) {
                binding.edtName.setError("Tidak boleh kosong");
                binding.edtPassword.setError("Tidak boleh kosong");
                binding.edtPhone.setError("Tidak boleh kosong");
            } else {
                presenter.registerUser(username, username, password, noPhone);
            }
        });

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(Boolean loading) {
        if(loading) {
            binding.pbLoading.setVisibility(View.VISIBLE);
            binding.btnRegister.setVisibility(View.GONE);
        } else {
            binding.pbLoading.setVisibility(View.VISIBLE);
            binding.btnRegister.setVisibility(View.GONE);
        }
    }
}