package com.example.weatherforecast.model.currentweather

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Sys: Serializable {
    @SerializedName("country")
    var country: String? = null
    @SerializedName("sunrise")
    var sunrise = 0
    @SerializedName("sunset")
    var sunset = 0
    @SerializedName("message")
    var message = 0.0

}