package com.samsul.aplikasiuser.presenter;

import com.samsul.aplikasiuser.data.model.ResponseGetData;
import com.samsul.aplikasiuser.networking.ApiClient;
import com.samsul.aplikasiuser.repository.ListContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPresenter implements ListContract.Presenter {

    private final ListContract.MainView view;

    public ListPresenter(ListContract.MainView view) {
        this.view = view;
        this.view.onCreateActivity();
    }

    @Override
    public void getData(int categoryBarang, int categoryGender, int categoryElectronic) {
        view.showLoading(true);
        ApiClient.getApiEndPoint().getData("crm_development", categoryBarang, categoryGender, categoryElectronic)
                .enqueue(new Callback<ResponseGetData>() {
                    @Override
                    public void onResponse(Call<ResponseGetData> call, Response<ResponseGetData> response) {
                        if(response.code() == 200 && response.isSuccessful()) {
                            ResponseGetData responseGetData = response.body();
                            assert responseGetData != null;
                            responseGetData.setData(responseGetData.getData());
                            view.showLoading(false);
                            view.resultListData(response.body());
                        } else {
                            view.showLoading(false);
                            view.showMessage("Terjadi kesalahan");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseGetData> call, Throwable t) {
                        view.showLoading(false);
                        view.showMessage("Tidak ada koneksi internet");
                    }
                });
    }
}
