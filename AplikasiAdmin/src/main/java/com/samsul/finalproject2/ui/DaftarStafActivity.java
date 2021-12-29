package com.samsul.finalproject2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.samsul.finalproject2.databinding.ActivityDaftarStafBinding;
import com.samsul.finalproject2.presenter.TambahStafPresenter;
import com.samsul.finalproject2.repository.TambahStafContract;

public class DaftarStafActivity extends AppCompatActivity implements TambahStafContract.MainView {

    private ActivityDaftarStafBinding binding;
    private TambahStafPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDaftarStafBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new TambahStafPresenter(this);
    }

    @Override
    public void onCreateActivity() {
        binding.btnDaftarstaf.setOnClickListener(v -> {
            String username = binding.edtUsername.getText().toString();
            String email = binding.edtEmail.getText().toString();
            String password = binding.edtPassword.getText().toString();
            String confirmPassword = binding.edtKonfirmasiPassword.getText().toString();

            if(username.isEmpty() && email.isEmpty() && password.isEmpty() && confirmPassword.isEmpty()) {
                binding.edtUsername.setError("Tidak boleh kosong");
                binding.edtEmail.setError("Tidak boleh kosong");
                binding.edtPassword.setError("Tidak boleh kosong");
                binding.edtKonfirmasiPassword.setError("Tidak boleh kosong");

            } else if(!password.equals(confirmPassword)) {
                showMessage("Password kurang tepat");
            } else {
                presenter.insertStaf(username, "sam", password, email);
            }

        });
        binding.imgBack.setOnClickListener(v -> {
            onBackPressed();
            DaftarStafActivity.this.finish();
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(DaftarStafActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(Boolean loading) {
        if(loading) {
            binding.pbLoading.setVisibility(View.VISIBLE);
            binding.btnDaftarstaf.setVisibility(View.GONE);
        } else {
            binding.pbLoading.setVisibility(View.GONE);
            binding.btnDaftarstaf.setVisibility(View.VISIBLE);
        }
    }
}