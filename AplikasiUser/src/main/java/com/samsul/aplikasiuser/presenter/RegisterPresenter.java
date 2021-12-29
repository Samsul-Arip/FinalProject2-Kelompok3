package com.samsul.aplikasiuser.presenter;

import com.samsul.aplikasiuser.data.model.ResponseRegister;
import com.samsul.aplikasiuser.networking.ApiClient;
import com.samsul.aplikasiuser.repository.RegisterContract;
import com.samsul.aplikasiuser.ui.RegisterActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.Presenter {

    private final RegisterContract.MainView view;

    public RegisterPresenter(RegisterContract.MainView view) {
        this.view = view;
        this.view.onCreateActivity();
    }

    @Override
    public void registerUser(String username, String name, String password, String noHp) {
        view.showLoading(true);
        ApiClient.getApiEndPoint().registerUser("crm_development",username, name, password, noHp).enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if(response.isSuccessful() && response.code() == 201) {
                    ResponseRegister responseRegister = response.body();
                    view.showLoading(false);
                    assert responseRegister != null;
                    responseRegister.setMessage(responseRegister.getMessage());
                    view.showMessage(responseRegister.getMessage());
                } else {
                    view.showLoading(false);
                    view.showMessage("Terjadi kesalahan");
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                view.showMessage("Periksa koneksi anda");
                view.showLoading(false);
            }
        });
    }
}
