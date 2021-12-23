package com.samsul.finalproject2.repository;

public interface TambahStafContract {

    interface Presenter {
        void insertStaf(String username,String name, String password, String email);
    }

    interface MainView {
        void onCreateActivity();
        void showMessage(String message);
        void showLoading(Boolean loading);
    }

}
