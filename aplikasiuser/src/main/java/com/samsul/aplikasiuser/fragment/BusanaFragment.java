package com.samsul.aplikasiuser.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samsul.aplikasiuser.R;
import com.samsul.aplikasiuser.data.Constant.Constant;
import com.samsul.aplikasiuser.databinding.FragmentBusanaBinding;
import com.samsul.aplikasiuser.ui.ListActivity;

public class BusanaFragment extends Fragment {

    private FragmentBusanaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBusanaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.viewBusanaPria.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ListActivity.class);
            intent.putExtra(Constant.categoryBarang, 1);
            intent.putExtra(Constant.categoryGender, 1);
            startActivity(intent);
        });
        binding.viewBusanaPerempuan.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ListActivity.class);
            intent.putExtra(Constant.categoryBarang, 1);
            intent.putExtra(Constant.categoryGender, 2);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}