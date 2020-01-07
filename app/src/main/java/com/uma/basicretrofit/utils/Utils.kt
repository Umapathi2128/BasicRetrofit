package com.uma.basicretrofit.utils

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.uma.basicretrofit.domain.API
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Umapathi on 2020-01-07.
 * Copyright Indyzen Inc, @2020
 */

object Utils {

    /**
     * Retrofit initializing...
     */
    private fun generateRetrofit() : Retrofit {
       return Retrofit.Builder()
           .baseUrl("https://testapi.io/api/crosscodedj/")
            .client(OkHttpClient().newBuilder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun getApiService() : API{
       return generateRetrofit().create(API::class.java)
    }
}