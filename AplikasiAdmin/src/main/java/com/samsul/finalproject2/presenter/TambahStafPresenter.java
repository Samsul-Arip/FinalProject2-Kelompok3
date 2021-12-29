package com.samsul.finalproject2.presenter;

import com.samsul.finalproject2.data.model.ResponseInsertStaf;
import com.samsul.finalproject2.networking.ApiClient;
import com.samsul.finalproject2.networking.ApiEndPoint;
import com.samsul.finalproject2.repository.TambahStafContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahStafPresenter implements TambahStafContract.Presenter {

    private final TambahStafContract.MainView view;

    public TambahStafPresenter(TambahStafContract.MainView view) {
        this.view = view;
        this.view.onCreateActivity();
    }

    @Override
    public void insertStaf(String username, String name, String password, String email) {
        view.showLoading(true);
        ApiClient.getApiEndPoint().insertStaf("crm_development", username, name, password, email)
                .enqueue(new Callback<ResponseInsertStaf>() {
                    @Override
                    public void onResponse(Call<ResponseInsertStaf> call, Response<ResponseInsertStaf> response) {
                        if (response.isSuccessful() && response.code() == 201) {
                            ResponseInsertStaf responseInsertStaf = response.body();
                            assert responseInsertStaf != null;
                            responseInsertStaf.setMessage(responseInsertStaf.getMessage());
                            view.showLoading(false);
                            view.showMessage(responseInsertStaf.getMessage());
                        } else {
                            view.showMessage("Terjadi kesalahan");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseInsertStaf> call, Throwable t) {
                        view.showMessage("Tidak ada sambungan internet");
                        view.showLoading(false);
                    }
                });
    }
}
