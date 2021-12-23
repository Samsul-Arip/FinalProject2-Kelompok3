package com.samsul.aplikasiuser.networking;

import com.samsul.aplikasiuser.data.model.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ApiEndPoint {
    /**
     * method dibawah untuk POST
     */
    @POST("Pelanggan/pelanggan")
    Call<ResponseRegister>
    registerUser(
            @Field("username") String username,
            @Field("name") String name,
            @Field("password") String password,
            @Field("no_hp") String noHp
    );

}
