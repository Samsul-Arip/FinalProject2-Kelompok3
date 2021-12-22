package com.samsul.finalproject2.networking;

import com.samsul.finalproject2.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClinet {

    public static ApiEndPoint getApiEndPoint() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(ApiEndPoint.class);

    }
}
