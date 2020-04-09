package com.example.weatherforecast.model.daysweather

import com.google.gson.annotations.SerializedName

class Temp {
    @SerializedName("min")
    var min = 0.0
    @SerializedName("max")
    var max = 0.0
    @SerializedName("eve")
    var eve = 0.0
    @SerializedName("night")
    var night = 0.0
    @SerializedName("day")
    var day = 0.0
    @SerializedName("morn")
    var morn = 0.0

}