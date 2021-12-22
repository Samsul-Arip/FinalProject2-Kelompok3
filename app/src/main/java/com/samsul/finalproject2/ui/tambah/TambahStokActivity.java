package com.samsul.finalproject2.ui.tambah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.samsul.finalproject2.databinding.ActivityTambahStokBinding;

public class TambahStokActivity extends AppCompatActivity {

    private ActivityTambahStokBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTambahStokBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}