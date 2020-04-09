package com.example.weatherforecast.model.fivedayweather

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class City : Serializable {
    @SerializedName("country")
    var country: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("id")
    var id = 0
    @SerializedName("population")
    var population = 0

}