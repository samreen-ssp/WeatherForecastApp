package com.example.weatherforecast.model.daysweather

import com.example.weatherforecast.model.common.WeatherItem
import com.google.gson.annotations.SerializedName

class ListItem {
    @SerializedName("dt")
    var dt = 0
    @SerializedName("temp")
    var temp: Temp? = null
    @SerializedName("deg")
    var deg = 0
    @SerializedName("weather")
    var weather: List<WeatherItem>? = null
    @SerializedName("humidity")
    var humidity = 0
    @SerializedName("pressure")
    var pressure = 0.0
    @SerializedName("clouds")
    var clouds = 0
    @SerializedName("speed")
    var speed = 0.0
    @SerializedName("rain")
    var rain = 0.0

}