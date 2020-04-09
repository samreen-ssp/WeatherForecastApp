package com.example.weatherforecast.model.fivedayweather

import com.google.gson.annotations.SerializedName

class Main {
    @SerializedName("temp")
    var temp = 0.0
    @SerializedName("tempMin")
    var tempMin = 0.0
    @SerializedName("grnd_level")
    var grndLevel = 0.0
    @SerializedName("temp_kf")
    var tempKf = 0.0
    @SerializedName("humidity")
    var humidity = 0
    @SerializedName("pressure")
    var pressure = 0.0
    @SerializedName("sea_level")
    var seaLevel = 0.0
    @SerializedName("tempMax")
    var tempMax = 0.0

}