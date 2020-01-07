package com.uma.basicretrofit.domain

import com.uma.basicretrofit.data.CarList
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Umapathi on 2020-01-07.
 * Copyright Indyzen Inc, @2020
 */
interface API {

    @GET("home")
    suspend fun getCarList() : Response<CarList>
}