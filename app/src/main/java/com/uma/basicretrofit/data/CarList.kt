package com.uma.basicretrofit.data

import com.google.gson.annotations.SerializedName

data class CarList(@SerializedName("valid")
                   val valid: String = "",
                   @SerializedName("data")
                   val data: List<DataItem>?,
                   @SerializedName("message")
                   val message: String = "")