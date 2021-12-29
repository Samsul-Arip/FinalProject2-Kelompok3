package com.samsul.finalproject2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.samsul.finalproject2.R;
import com.samsul.finalproject2.data.preferences.LocalPreferences;
import com.samsul.finalproject2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private LocalPreferences localPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        localPreferences = new LocalPreferences(this);
        binding.toolbarHome.inflateMenu(R.menu.item_menu);
        binding.toolbarHome.setOnMenuItemClickListener(item -> {
            if(item.getItemId() == R.id.menu_logOut) {
                localPreferences.getEditor().clear().apply();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                Toast.makeText(MainActivity.this, "Berhasil Keluar", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
        binding.btnDaftarstaf.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DaftarStafActivity.class);
            startActivity(intent);
        });
        binding.btnTambahStok.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TambahStokActivity.class);
            startActivity(intent);
        });

    }
}