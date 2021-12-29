package com.samsul.aplikasi.presenter;

import com.samsul.aplikasi.data.model.ResponseLoginStaf;
import com.samsul.aplikasi.network.ApiClient;
import com.samsul.aplikasi.respository.LoginContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.MainView view;

    public LoginPresenter(LoginContract.MainView view) {
        this.view = view;
        this.view.onCreateActivity();
    }

    @Override
    public void loginStaf(String username, String password) {
        view.showLoading(true);
        ApiClient.getApiEndPoint().loginStaf("crm_development", username, password).enqueue(new Callback<ResponseLoginStaf>() {
            @Override
            public void onResponse(Call<ResponseLoginStaf> call, Response<ResponseLoginStaf> response) {
                if(response.isSuccessful() && response.code() == 201) {
                    view.showLoading(false);
                    view.showMessage("Berhasil Login");
                    view.nextActivity();

                } else {
                    view.showMessage("Terjadi kesalahan");
                    view.showLoading(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseLoginStaf> call, Throwable t) {
                view.showLoading(false);
                view.showMessage("Periksa koneksi anda");
            }
        });
    }
}
