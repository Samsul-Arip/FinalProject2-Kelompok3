package com.samsul.finalproject2.ui.tambah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.samsul.finalproject2.databinding.ActivityDaftarStafBinding;

public class DaftarStafActivity extends AppCompatActivity {

    private ActivityDaftarStafBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDaftarStafBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}