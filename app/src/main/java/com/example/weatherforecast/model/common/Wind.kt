package com.example.weatherforecast.model.common

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Wind: Serializable {
    @SerializedName("deg")
    var deg = 0.0
    @SerializedName("speed")
    var speed = 0.0

}