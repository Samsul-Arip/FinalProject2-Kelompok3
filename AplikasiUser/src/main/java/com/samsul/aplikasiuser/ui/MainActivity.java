package com.samsul.aplikasiuser.ui;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayoutMediator;
import com.samsul.aplikasiuser.R;
import com.samsul.aplikasiuser.adapter.SectionPagerAdapter;
import com.samsul.aplikasiuser.data.preferences.LocalPreferences;
import com.samsul.aplikasiuser.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3
    };
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
                MainActivity.this.finish();
                return true;
            }
            return false;
        });

        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(this);
        binding.viewPager.setAdapter(sectionPagerAdapter);
        new TabLayoutMediator(binding.tabs, binding.viewPager,
                (tab, position) -> tab.setText(getResources().getString(TAB_TITLES[position]))
        ).attach();

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }
}