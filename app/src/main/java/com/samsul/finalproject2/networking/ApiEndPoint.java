package com.samsul.finalproject2.networking;

import com.samsul.finalproject2.data.model.ResponseInsertBarang;
import com.samsul.finalproject2.data.model.ResponseInsertStaf;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiEndPoint {

    /**
     * method dibawah untuk post
     */
    @Multipart
    @POST("Barang/barang")
    @Headers("Authorization: Basic Y3JtOjEyMw==")
    Call<ResponseInsertBarang>
    insertData(
            @Header("taco-auth-key") String auth,
            @Part MultipartBody.Part files,
            @Part("kategory_barang") RequestBody categoryBarang,
            @Part("name") RequestBody name,
            @Part("kategory_gender") RequestBody categoryGender,
            @Part("kategory_elektronik") RequestBody categoryElectronic,
            @Part("stok_barang") RequestBody stockBarang,
            @Part("deskripsi") RequestBody description
    );

    @FormUrlEncoded
    @POST("Admin/admin")
    @Headers("Authorization: Basic Y3JtOjEyMw==")
    Call<ResponseInsertStaf>
    insertStaf(
            @Header("taco-auth-key") String auth,
            @Field("username") String username,
            @Field("name") String name,
            @Field("password") String password,
            @Field("email") String email
    );
}
