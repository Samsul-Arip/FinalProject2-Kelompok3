package com.samsul.aplikasiuser.presenter;

import com.samsul.aplikasiuser.data.model.ResponseDetail;
import com.samsul.aplikasiuser.networking.ApiClient;
import com.samsul.aplikasiuser.repository.DetailContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter implements DetailContract.Presenter {

    private final DetailContract.MainView view;

    public DetailPresenter(DetailContract.MainView view) {
        this.view = view;
        this.view.onCreateActivity();
    }

    @Override
    public void getDetail(int id) {
        view.showLoading(true);
        ApiClient.getApiEndPoint().getDetail("crm_development", id).enqueue(new Callback<ResponseDetail>() {
            @Override
            public void onResponse(Call<ResponseDetail> call, Response<ResponseDetail> response) {
                if(response.isSuccessful() && response.code() == 200) {
                    ResponseDetail responseDetail = response.body();
                    view.showLoading(false);
                    view.resultDetail(responseDetail);
                } else {
                    view.showMessage("Terjadi kesalahan");
                    view.showLoading(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseDetail> call, Throwable t) {
                view.showMessage("Tidak ada koneksi internet");
                view.showLoading(false);
            }
        });
    }
}
