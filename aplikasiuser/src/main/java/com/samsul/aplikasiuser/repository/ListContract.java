package com.samsul.aplikasiuser.repository;

import com.samsul.aplikasiuser.data.model.ResponseGetData;

public interface ListContract {

    interface Presenter {
        void getData(int categoryBarang,int categoryGender,int categoryElectronic);
    }
    interface MainView {
        void onCreateActivity();
        void showMessage(String message);
        void showLoading(Boolean loading);
        void resultListData(ResponseGetData data);
    }
}
