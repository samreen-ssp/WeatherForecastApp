package com.example.weatherforecast.model.fivedayweather

import com.example.weatherforecast.model.common.Clouds
import com.example.weatherforecast.model.common.WeatherItem
import com.example.weatherforecast.model.common.Wind
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

class ItemHourly: Serializable {
    @SerializedName("dt")
    var dt = 0
    @SerializedName("dt_txt")
    var dtTxt: String? = null
    @SerializedName("weather")
    var weather: ArrayList<WeatherItem>? = null
    @SerializedName("main")
    var main: Main? = null
    @SerializedName("clouds")
    var clouds: Clouds? = null
    @SerializedName("sys")
    var sys: Sys? = null
    @SerializedName("wind")
    var wind: Wind? = null
    @SerializedName("rain")
    var rain: Rain? = null

    fun getTimeTitle(): String? {
        val strs = dtTxt?.split(" ")?.toTypedArray()
        return strs?.get(1)
    }

}