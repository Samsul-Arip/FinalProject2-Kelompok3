package com.samsul.aplikasiuser.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import com.samsul.aplikasiuser.data.Constant.Constant;
import com.samsul.aplikasiuser.data.model.ResponseDetail;
import com.samsul.aplikasiuser.databinding.ActivityDetailBinding;
import com.samsul.aplikasiuser.presenter.DetailPresenter;
import com.samsul.aplikasiuser.repository.DetailContract;

public class DetailActivity extends AppCompatActivity implements DetailContract.MainView {

    private ActivityDetailBinding binding;
    private DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        detailPresenter = new DetailPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        int idItem = intent.getIntExtra(Constant.ID_LIST,0);
        detailPresenter.getDetail(idItem);
    }

    @Override
    public void onCreateActivity() {
        binding.imgBack.setOnClickListener(v -> {
            onBackPressed();
            DetailActivity.this.finish();
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(DetailActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(Boolean loading) {
        if(loading) {
            binding.pbLoading.setVisibility(View.VISIBLE);
            binding.viewDescription.setVisibility(View.GONE);
        } else {
            binding.pbLoading.setVisibility(View.GONE);
            binding.viewDescription.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void resultDetail(ResponseDetail responseDetail) {
        String data = responseDetail.getData().get(0).getImage();
        String name = responseDetail.getData().get(0).getName();
        String description = responseDetail.getData().get(0).getDeskripsi();

        byte[] imageAsBytes = Base64.decode(data, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
        binding.imgDetail.setImageBitmap(decodedByte);
        binding.tvName.setText(name);
        binding.tvDescription.setText(description);
    }
}