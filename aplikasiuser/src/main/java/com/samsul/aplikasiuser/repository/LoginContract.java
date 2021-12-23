package com.samsul.aplikasiuser.repository;

public interface LoginContract {
    interface Presenter {
        void loginUser(String noPhone, String password);
    }

    interface MainView {
        void onCreateActivity();
        void showMessage(String message);
        void showLoading(Boolean loading);
        void nextActivity();
    }
}
