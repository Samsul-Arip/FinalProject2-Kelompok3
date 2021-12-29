package com.samsul.aplikasiuser.data.model;

import com.google.gson.annotations.SerializedName;
import com.samsul.aplikasiuser.data.model.data.DataDetail;
import com.samsul.aplikasiuser.data.model.data.DataGet;

import java.util.List;

public class ResponseDetail {

    @SerializedName("status")
    String status;
    @SerializedName("responses")
    String responses;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<DataDetail> data;

    public ResponseDetail(String status, String responses, String message, List<DataDetail> data) {
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

    public List<DataDetail> getData() {
        return data;
    }

    public void setData(List<DataDetail> data) {
        this.data = data;
    }
}
