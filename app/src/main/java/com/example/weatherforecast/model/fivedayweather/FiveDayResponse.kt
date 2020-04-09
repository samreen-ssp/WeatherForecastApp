package com.example.weatherforecast.model.fivedayweather

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class FiveDayResponse : Serializable {
    @SerializedName("city")
    var city: City? = null
    @SerializedName("cnt")
    var cnt = 0
    @SerializedName("cod")
    var cod: String? = null
    @SerializedName("message")
    var message = 0.0
    @SerializedName("list")
    var list: List<ItemHourly>? = null

}