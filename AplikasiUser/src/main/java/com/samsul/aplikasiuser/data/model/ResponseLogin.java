package com.samsul.aplikasiuser.data.model;

import com.google.gson.annotations.SerializedName;
import com.samsul.aplikasiuser.data.model.data.DataLogin;

import java.util.List;

public class ResponseLogin {

    @SerializedName("response")
    String response;
    @SerializedName("status")
    Boolean status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<DataLogin> dataLogin;

    public ResponseLogin(String response, Boolean status, String message, List<DataLogin> dataLogin) {
        this.response = response;
        this.status = status;
        this.message = message;
        this.dataLogin = dataLogin;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataLogin> getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(List<DataLogin> dataLogin) {
        this.dataLogin = dataLogin;
    }
}
