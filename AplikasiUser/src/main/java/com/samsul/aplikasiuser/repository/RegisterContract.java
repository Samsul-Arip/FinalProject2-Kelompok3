package com.samsul.aplikasiuser.repository;

public interface RegisterContract {

    interface Presenter {
        void registerUser(String username, String name, String password, String noHp);
    }

    interface MainView {
        void onCreateActivity();
        void showMessage(String message);
        void showLoading(Boolean loading);
    }

}
