package com.samsul.aplikasiuser.data.model.data;

import com.google.gson.annotations.SerializedName;

public class DataDetail {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("upload_gambar")
    String image;
    @SerializedName("deskripsi")
    String deskripsi;

    public DataDetail(int id, String name, String image, String deskripsi) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.deskripsi = deskripsi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
