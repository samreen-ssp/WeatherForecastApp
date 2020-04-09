package com.example.weatherforecast.model.daysweather

import com.google.gson.annotations.SerializedName

class MultipleDaysWeatherResponse {
    @SerializedName("city")
    var city: City? = null
    @SerializedName("cnt")
    var cnt = 0
    @SerializedName("cod")
    var cod: String? = null
    @SerializedName("message")
    var message = 0.0
    @SerializedName("list")
    var list: List<ListItem>? =
        null

}