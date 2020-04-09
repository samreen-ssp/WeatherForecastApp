package com.example.weatherforecast.model.common

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Clouds: Serializable {
    @SerializedName("all")
    var all = 0

}