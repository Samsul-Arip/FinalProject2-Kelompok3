package com.samsul.aplikasiuser.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samsul.aplikasiuser.data.Constant.Constant;
import com.samsul.aplikasiuser.databinding.FragmentLainnyaBinding;
import com.samsul.aplikasiuser.ui.ListActivity;


public class LainnyaFragment extends Fragment {

    private FragmentLainnyaBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLainnyaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.viewBuku.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ListActivity.class);
            intent.putExtra(Constant.CATEGORY_BARANG, 3);
            startActivity(intent);
        });

        binding.viewOther.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ListActivity.class);
            intent.putExtra(Constant.CATEGORY_BARANG, 4);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}