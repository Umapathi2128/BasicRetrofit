package com.uma.basicretrofit.data

import com.google.gson.annotations.SerializedName

data class DataItem(@SerializedName("lat_location")
                    val latLocation: Double = 0.0,
                    @SerializedName("date")
                    val date: String = "",
                    @SerializedName("is_share")
                    val isShare: Int = 0,
                    @SerializedName("available_count")
                    val availableCount: Int = 0,
                    @SerializedName("description")
                    val description: String = "",
                    @SerializedName("is_favourite")
                    val isFavourite: Int = 0,
                    @SerializedName("title")
                    val title: String = "",
                    @SerializedName("web_link")
                    val webLink: String = "",
                    @SerializedName("image_url_banner")
                    val imageUrlBanner: String = "",
                    @SerializedName("is_sold")
                    val isSold: Int = 0,
                    @SerializedName("lon_location")
                    val lonLocation: Double = 0.0,
                    @SerializedName("image_url_tumbnail")
                    val imageUrlTumbnail: String = "",
                    @SerializedName("id")
                    val id: Int = 0,
                    @SerializedName("is_purchased")
                    val isPurchased: Int? = null)