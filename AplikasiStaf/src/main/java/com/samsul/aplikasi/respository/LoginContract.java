package com.samsul.aplikasi.respository;

public interface LoginContract {

    interface Presenter {
        void loginStaf(String username, String password);
    }

    interface MainView {
        void onCreateActivity();
        void showLoading(Boolean loading);
        void showMessage(String message);
        void nextActivity();
    }
}
