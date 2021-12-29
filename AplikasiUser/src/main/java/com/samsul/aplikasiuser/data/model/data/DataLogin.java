package com.samsul.aplikasiuser.data.model.data;

import com.google.gson.annotations.SerializedName;

public class DataLogin {

    @SerializedName("id")
    int id;
    @SerializedName("username")
    String username;
    @SerializedName("name")
    String name;
    @SerializedName("no_hp")
    String noPhone;

    public DataLogin(int id, String username, String name, String noPhone) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.noPhone = noPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoPhone() {
        return noPhone;
    }

    public void setNoPhone(String noPhone) {
        this.noPhone = noPhone;
    }
}
