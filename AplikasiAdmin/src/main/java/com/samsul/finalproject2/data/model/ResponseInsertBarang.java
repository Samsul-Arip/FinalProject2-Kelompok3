package com.samsul.finalproject2.data.model;

import com.google.gson.annotations.SerializedName;

public class ResponseInsertBarang {

    @SerializedName("response")
    String response;
    @SerializedName("status")
    Boolean status;
    @SerializedName("message")
    String message;

    public ResponseInsertBarang(String response, Boolean status, String message) {
        this.response = response;
        this.status = status;
        this.message = message;
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
}
