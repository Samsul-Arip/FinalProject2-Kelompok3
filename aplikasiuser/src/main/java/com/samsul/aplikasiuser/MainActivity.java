package com.samsul.aplikasiuser;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayoutMediator;
import com.samsul.aplikasiuser.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.tab_text_1,
            R.string.tab_text_2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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