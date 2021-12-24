package com.samsul.aplikasiuser.repository;

import com.samsul.aplikasiuser.data.model.ResponseDetail;

public interface DetailContract {

    interface Presenter {
        void getDetail(int id);
    }

    interface MainView {
        void onCreateActivity();
        void showMessage(String message);
        void showLoading(Boolean loading);
        void resultDetail(ResponseDetail responseDetail);
    }
}
