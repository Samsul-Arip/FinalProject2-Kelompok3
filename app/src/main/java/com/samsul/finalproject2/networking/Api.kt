package com.samsul.finalproject2.networking

import androidx.core.content.ContextCompat
import com.samsul.finalproject2.repository.TambahStockContract
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

class Api (val context: TambahStockContract.MainView){

   init {
      context.onCreateActivity()
   }
}