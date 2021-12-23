package com.samsul.finalproject2.networking;

import com.samsul.finalproject2.data.model.ResponseInsertBarang;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiEndPoint {

//    @GET("users")
//    Call<List<ResponseData>> getUsers();

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


}
