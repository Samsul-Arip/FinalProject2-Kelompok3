package com.samsul.finalproject2.repository;

import com.samsul.finalproject2.data.model.ResponseInsertBarang;

import java.io.File;

public interface TambahStockContract {

    interface Presenter {
        void insertStock(File files, int categoryBarang, String name, int categoryGender,
                         int categoryElektronik, int stokBarang, String deskripsi);
    }

    interface MainView {
        void onCreateActivity();
        void showLoading(Boolean loading);
        void showMessage(String message);
        void resultInsertStock(ResponseInsertBarang result);
    }
}
