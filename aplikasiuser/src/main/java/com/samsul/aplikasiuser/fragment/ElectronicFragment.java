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
import com.samsul.aplikasiuser.databinding.FragmentElectronicBinding;
import com.samsul.aplikasiuser.ui.ListActivity;


public class ElectronicFragment extends Fragment {

    private FragmentElectronicBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentElectronicBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.viewKomputer.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ListActivity.class);
            intent.putExtra(Constant.CATEGORY_BARANG,2);
            intent.putExtra(Constant.CATEGORY_ELECTRONIC, 1);
            startActivity(intent);
        });

        binding.viewSmartPhone.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ListActivity.class);
            intent.putExtra(Constant.CATEGORY_BARANG,2);
            intent.putExtra(Constant.CATEGORY_ELECTRONIC, 2);
            startActivity(intent);
        });
    }
}