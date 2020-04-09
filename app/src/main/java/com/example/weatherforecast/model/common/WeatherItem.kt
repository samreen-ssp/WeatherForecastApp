package com.example.weatherforecast.model.common

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class WeatherItem: Serializable {
    @SerializedName("icon")
    var icon: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("main")
    var main: String? = null
    @SerializedName("id")
    var id = 0

}