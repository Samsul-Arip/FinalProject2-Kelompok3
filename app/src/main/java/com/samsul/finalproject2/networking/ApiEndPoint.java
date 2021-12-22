package com.samsul.finalproject2.networking;

import com.samsul.finalproject2.data.model.ResponseInsertBarang;

import okhttp3.MultipartBody;
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
            @Query("kategory_barang") int categoryBarang,
            @Query("name") String name,
            @Query("kategory_gender") int categoryGender,
            @Query("kategory_elektronik") int categoryElectronic,
            @Query("stok_barang") int stockBarang,
            @Query("deskripsi") String description
    );


}
