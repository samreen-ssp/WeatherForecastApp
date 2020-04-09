package com.example.weatherforecast.model.currentweather

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Main: Serializable {
    @SerializedName("temp")
    var temp = 0.0
    @SerializedName("temp_min")
    var tempMin = 0.0
    @SerializedName("grnd_level")
    var grndLevel = 0.0
    @SerializedName("humidity")
    var humidity = 0
    @SerializedName("pressure")
    var pressure = 0.0
    @SerializedName("sea_level")
    var seaLevel = 0.0
    @SerializedName("temp_max")
    var tempMax = 0.0

}