package com.example.weatherforecast.model.daysweather

import com.example.weatherforecast.model.common.Coord
import com.google.gson.annotations.SerializedName

class City {
    @SerializedName("country")
    var country: String? = null
    @SerializedName("coord")
    var coord: Coord? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("id")
    var id = 0
    @SerializedName("population")
    var population = 0

}