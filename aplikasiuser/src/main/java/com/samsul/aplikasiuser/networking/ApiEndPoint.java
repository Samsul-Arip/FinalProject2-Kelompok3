package com.samsul.aplikasiuser.networking;

import com.samsul.aplikasiuser.data.model.ResponseDetail;
import com.samsul.aplikasiuser.data.model.ResponseGetData;
import com.samsul.aplikasiuser.data.model.ResponseLogin;
import com.samsul.aplikasiuser.data.model.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiEndPoint {
    /**
     * method dibawah untuk POST
     */
    @FormUrlEncoded
    @POST("Pelanggan/pelanggan")
    @Headers("Authorization: Basic Y3JtOjEyMw==")
    Call<ResponseRegister>
    registerUser(
            @Header("taco-auth-key") String auth,
            @Field("username") String username,
            @Field("name") String name,
            @Field("password") String password,
            @Field("no_hp") String noHp
    );

    @FormUrlEncoded
    @POST("Login/loginPelanggan")
    @Headers("Authorization: Basic Y3JtOjEyMw==")
    Call<ResponseLogin>
    loginUser(
            @Header("taco-auth-key") String auth,
            @Field("no_hp") String noPhone,
            @Field("password") String password
    );

    /**
     * Method dibawah untuk GET
     */
    @GET("Barang/getFilterBarang")
    @Headers("Authorization: Basic Y3JtOjEyMw==")
    Call<ResponseGetData>
    getData(
            @Header("taco-auth-key") String auth,
            @Query("kategory_barang") int categoryBarang,
            @Query("kategory_gender") int categoryGender,
            @Query("kategory_elektronik") int categoryElektronik
    );

    @GET("Barang/getDetailBarang")
    @Headers("Authorization: Basic Y3JtOjEyMw==")
    Call<ResponseDetail>
    getDetail(
            @Header("taco-auth-key") String auth,
            @Query("id") int id
    );

}
