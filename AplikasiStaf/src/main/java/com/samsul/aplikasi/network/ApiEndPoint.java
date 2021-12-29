package com.samsul.aplikasi.network;

import com.samsul.aplikasi.data.model.ResponseLoginStaf;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiEndPoint {

    @FormUrlEncoded
    @POST("Pelanggan/pelanggan")
    @Headers("Authorization: Basic Y3JtOjEyMw==")
    Call<ResponseLoginStaf>
    loginStaf(
            @Header("taco-auth-key") String auth,
            @Field("username") String username,
            @Field("password") String password
    );

}
