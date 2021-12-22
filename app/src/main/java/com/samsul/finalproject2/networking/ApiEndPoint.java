package com.samsul.finalproject2.networking;

import com.samsul.finalproject2.data.model.ResponseInsertBarang;

import okhttp3.MultipartBody;
import retrofit2.Call;
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
    Call<ResponseInsertBarang>
    insertData(
            @Part MultipartBody.Part files,
            @Query("kategory_barang") int categoryBarang,
            @Query("name") String name,
            @Query("kategory_gender") int categoryGender,
            @Query("kategory_elektronik") int categoryElectronic,
            @Query("stok_barang") int stockBarang,
            @Query("deskripsi") String description
    );


}
