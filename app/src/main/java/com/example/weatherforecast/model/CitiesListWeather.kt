package com.example.weatherforecast.model

import com.example.weatherforecast.model.currentweather.CurrentWeatherResponse
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CitiesListWeather : Serializable {
    @SerializedName("cnt")
    var cnt:Int =0
    @SerializedName("list")
    var list: List<CurrentWeatherResponse?>? = null

}