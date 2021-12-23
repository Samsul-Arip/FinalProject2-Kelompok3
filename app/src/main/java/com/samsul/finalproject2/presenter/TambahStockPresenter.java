package com.samsul.finalproject2.presenter;

import android.util.Log;

import androidx.annotation.NonNull;

import com.samsul.finalproject2.data.model.ResponseInsertBarang;
import com.samsul.finalproject2.networking.ApiClient;
import com.samsul.finalproject2.repository.TambahStockContract;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahStockPresenter implements TambahStockContract.Presenter{

    TambahStockContract.MainView view;

    public TambahStockPresenter(TambahStockContract.MainView view) {
        this.view = view;
        this.view.onCreateActivity();
    }

    @Override
    public void insertStock(File files, int categoryBarang, String name, int categoryGender, int categoryElektronik, int stokBarang, String deskripsi) {
        RequestBody cB = RequestBody.create(MultipartBody.FORM, String.valueOf(categoryBarang));
        RequestBody nama = RequestBody.create(MultipartBody.FORM, String.valueOf(name));
        RequestBody cG = RequestBody.create(MultipartBody.FORM, String.valueOf(categoryGender));
        RequestBody cE = RequestBody.create(MultipartBody.FORM, String.valueOf(categoryElektronik));
        RequestBody sB = RequestBody.create(MultipartBody.FORM, String.valueOf(stokBarang));
        RequestBody desc = RequestBody.create(MultipartBody.FORM, String.valueOf(deskripsi));
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), files);
        @NonNull MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("files", files.getName(), requestBody);
        view.showLoading(true);
        ApiClient.getApiEndPoint().insertData("crm_development",multipartBody, cB, nama, cG, cE, sB, desc)
                .enqueue(new Callback<ResponseInsertBarang>() {
                    @Override
                    public void onResponse(Call<ResponseInsertBarang> call, Response<ResponseInsertBarang> response) {
                        if(response.isSuccessful() && response.code() == 201) {
                            ResponseInsertBarang responseInsertBarang = response.body();
                            assert responseInsertBarang != null;
                            assert response.body() != null;
                            responseInsertBarang.setMessage(response.body().getMessage());
                            view.showLoading(false);
                            assert response.body() != null;
                            view.showMessage(response.body().getMessage());
                        } else {
                            view.showLoading(false);
                            assert response.body() != null;
                            view.showMessage(response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseInsertBarang> call, Throwable t) {
                        Log.d("Failut :", t.getMessage());
                    }
                });
    }
}
