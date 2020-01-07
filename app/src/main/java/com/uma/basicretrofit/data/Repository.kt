package com.uma.basicretrofit.data

import com.uma.basicretrofit.utils.Utils

/**
 * Created by Umapathi on 2020-01-07.
 * Copyright Indyzen Inc, @2020
 */
class Repository {

    private val carList: MutableList<DataItem> = mutableListOf()

    suspend fun getList() : List<DataItem>{

        val response = Utils.getApiService().getCarList()
        if (response.isSuccessful){
            val list = response.body()?.data
            list?.let { carList.addAll(it) }
        }
        return carList
    }
}