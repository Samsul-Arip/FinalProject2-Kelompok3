package com.samsul.aplikasiuser.data.model;

import com.google.gson.annotations.SerializedName;
import com.samsul.aplikasiuser.data.model.data.DataGet;

import java.util.List;

public class ResponseGetData {

    @SerializedName("status")
    String status;
    @SerializedName("responses")
    String responses;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<DataGet> data;

    public ResponseGetData(String status, String responses, String message, List<DataGet> data) {
        this.status = status;
        this.responses = responses;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponses() {
        return responses;
    }

    public void setResponses(String responses) {
        this.responses = responses;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataGet> getData() {
        return data;
    }

    public void setData(List<DataGet> data) {
        this.data = data;
    }
}
