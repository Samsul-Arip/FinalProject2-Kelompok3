package com.samsul.finalproject2.ui.tambah;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.samsul.finalproject2.databinding.ActivityTambahStokBinding;
import com.samsul.finalproject2.presenter.TambahStockPresenter;
import com.samsul.finalproject2.repository.TambahStockContract;
import com.samsul.finalproject2.utils.FileUtils;
import com.samsul.finalproject2.utils.GaleryHelper;

public class TambahStokActivity extends AppCompatActivity implements TambahStockContract.MainView {

    private ActivityTambahStokBinding binding;
    private TambahStockPresenter presenter;


    private Uri uriImage = null;
    private final int pickImage = 1;
    private int categoryGender, categoryElectronic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTambahStokBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new TambahStockPresenter(this);
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
        binding.spinCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        binding.spinCategoryGender.setVisibility(View.VISIBLE);
                        binding.spinCategoryElectronic.setVisibility(View.GONE);
                        break;
                    case 2:
                        binding.spinCategoryGender.setVisibility(View.GONE);
                        binding.spinCategoryElectronic.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                    case 4:
                        binding.spinCategoryGender.setVisibility(View.GONE);
                        binding.spinCategoryElectronic.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.btnTambahStok.setOnClickListener(v -> {
            int categoryBarang = binding.spinCategory.getSelectedItemPosition();
            int categoryBusana = binding.spinCategoryGender.getSelectedItemPosition();
            int categoryElc = binding.spinCategoryElectronic.getSelectedItemPosition();
            String name = binding.edtNamabarang.getText().toString();
            int stockBarang = Integer.parseInt(binding.edtStock.getText().toString());

           switch (categoryBarang) {
               case 0:
                   categoryBarang = 0;
                   categoryGender = 0;
                   categoryElectronic = 0;
                   break;
               case 1:
                   categoryGender = categoryBusana;
                   break;
               case 2:
                   categoryElectronic = categoryElc;
                   break;
           }
           if(name.isEmpty() && stockBarang == 0) {
               binding.edtNamabarang.setError("Tidak boleh kosong");
               binding.edtStock.setError("Harus diisi data");
           } else if(uriImage.toString().isEmpty()) {
               showMessage("Gambar harus diisi");
           } else {
               presenter.insertStock(
                       FileUtils.getFile(this, uriImage), categoryBarang, name,
                       categoryGender, categoryElectronic, stockBarang, "Ini hanyalah percobaan");
           }
        });

    }

    @Override
    public void showLoading(Boolean loading) {
        if (loading) {
            binding.pbLoading.setVisibility(View.VISIBLE);
            binding.btnTambahStok.setVisibility(View.GONE);
        } else {
            binding.pbLoading.setVisibility(View.GONE);
            binding.btnTambahStok.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(TambahStokActivity.this, message, Toast.LENGTH_SHORT).show();
    }


}