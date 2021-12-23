package com.samsul.aplikasiuser.presenter;

import com.samsul.aplikasiuser.data.model.ResponseLogin;
import com.samsul.aplikasiuser.networking.ApiClient;
import com.samsul.aplikasiuser.repository.LoginContract;

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
    public void loginUser(String noPhone, String password) {
        view.showLoading(true);
        ApiClient.getApiEndPoint().loginUser("crm_development", noPhone, password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if(response.isSuccessful() && response.code() == 200) {
                    ResponseLogin responseLogin = response.body();
                    view.showLoading(false);
                    view.showMessage("Login Berhasil");
                    view.nextActivity();
                } else {
                    view.showMessage("Terjadi kesalahan");
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                view.showMessage("Periksa koneksi anda");
                view.showLoading(false);

            }
        });
    }
}
