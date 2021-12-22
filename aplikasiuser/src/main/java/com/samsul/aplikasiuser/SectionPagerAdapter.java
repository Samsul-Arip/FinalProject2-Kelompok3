package com.samsul.aplikasiuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.samsul.aplikasiuser.fragment.BusanaFragment;
import com.samsul.aplikasiuser.fragment.ElectronicFragment;

public class SectionPagerAdapter extends FragmentStateAdapter {

    public SectionPagerAdapter(AppCompatActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new BusanaFragment();
                break;
            case 1:
                fragment = new ElectronicFragment();
                break;
        }

        assert fragment != null;
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}