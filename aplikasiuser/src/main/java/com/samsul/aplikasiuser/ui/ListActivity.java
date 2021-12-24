package com.samsul.aplikasiuser.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.samsul.aplikasiuser.R;
import com.samsul.aplikasiuser.adapter.ListAdapter;
import com.samsul.aplikasiuser.data.Constant.Constant;
import com.samsul.aplikasiuser.data.model.ResponseGetData;
import com.samsul.aplikasiuser.data.model.data.DataGet;
import com.samsul.aplikasiuser.databinding.ActivityListBinding;
import com.samsul.aplikasiuser.presenter.ListPresenter;
import com.samsul.aplikasiuser.repository.ListContract;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements ListContract.MainView {


    private ActivityListBinding binding;
    private ListPresenter presenter;
    private ListAdapter listAdapter;

    int categoryBarang, categoryGender, categoryElectronic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new ListPresenter(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        int cB = intent.getIntExtra(Constant.CATEGORY_BARANG, 0);
        int cG = intent.getIntExtra(Constant.CATEGORY_GENDER, 0);
        int cE = intent.getIntExtra(Constant.CATEGORY_ELECTRONIC, 0);

        switch (cB) {
            case 1:
                categoryBarang = 1;
                binding.tvTitleToolbar.setText(getResources().getText(R.string.busana));
                break;
            case 2:
                categoryBarang = 2;
                binding.tvTitleToolbar.setText(getResources().getText(R.string.elekronik));
                break;
        }
        switch (cG) {
            case 0:
                categoryGender = 0;
            case 1:
                categoryGender = 1;
                break;
            case 2:
                categoryGender = 2;
                break;
        }

        switch (cE) {
            case 0:
                categoryElectronic = 0;
            case 1:
                categoryElectronic = 1;
                break;
            case 2:
                categoryElectronic = 2;
                break;
        }
        presenter.getData(categoryBarang, categoryGender, categoryElectronic);
    }

    @Override
    public void onCreateActivity() {
        listAdapter = new ListAdapter();
        binding.rvListData.setLayoutManager(new LinearLayoutManager(this));
        binding.rvListData.setHasFixedSize(true);
        binding.rvListData.setAdapter(listAdapter);

        binding.imgBack.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(ListActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(Boolean loading) {
        if(loading) {
            binding.pbLoading.setVisibility(View.VISIBLE);
            binding.rvListData.setVisibility(View.GONE);
        } else {
            binding.pbLoading.setVisibility(View.GONE);
            binding.rvListData.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void resultListData(ResponseGetData data) {
        listAdapter.setData(data.getData());
    }
}