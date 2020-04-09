package com.example.weatherforecast.model.fivedayweather

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Rain: Serializable {
    @SerializedName("3h")
    var jsonMember3h = 0.0

}