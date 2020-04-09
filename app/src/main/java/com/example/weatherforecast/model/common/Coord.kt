package com.example.weatherforecast.model.common

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Coord: Serializable {
    @SerializedName("lon")
    var lon = 0.0
    @SerializedName("lat")
    var lat = 0.0

}