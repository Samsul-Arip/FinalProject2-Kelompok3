package com.samsul.finalproject2.ui.tambah;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.samsul.finalproject2.data.model.ResponseInsertBarang;
import com.samsul.finalproject2.databinding.ActivityTambahStokBinding;
import com.samsul.finalproject2.presenter.TambahStockPresenter;
import com.samsul.finalproject2.repository.TambahStockContract;
import com.samsul.finalproject2.utils.FileUtils;
import com.samsul.finalproject2.utils.GaleryHelper;

public class TambahStokActivity extends AppCompatActivity implements TambahStockContract.MainView {

    private ActivityTambahStokBinding binding;
    private TambahStockPresenter presenter;
    private ResponseInsertBarang responseModel;

    private Uri uriImage = null;
    private final int pickImage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTambahStokBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new TambahStockPresenter(this);

        binding.btnTambahStok.setOnClickListener(v -> {
            presenter.insertStock(FileUtils.getFile(this, uriImage), 1, "Baju",
                    1, 0, 99, "ini adalah baju gaul");
            showMessage("Test");

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pickImage && resultCode == Activity.RESULT_OK) {
            assert data != null;
            uriImage = data.getData();
            binding.imgUploadImage.setImageURI(uriImage);
        }
    }


    @Override
    public void onCreateActivity() {
        binding.imgUploadImage.setOnClickListener(v -> {
            if (GaleryHelper.permissionGalerry(this, this, pickImage)) {
                GaleryHelper.openGalery(TambahStokActivity.this);
            }
        });


    }

    @Override
    public void showLoading(Boolean loading) {
        if (loading) {

        } else {

        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(TambahStokActivity.this, "Berhasil Tambah stock", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resultInsertStock(ResponseInsertBarang result) {
        responseModel.setMessage(result.getMessage());
        responseModel.setStatus(result.getStatus());
        responseModel.setResponse(result.getResponse());
    }


}