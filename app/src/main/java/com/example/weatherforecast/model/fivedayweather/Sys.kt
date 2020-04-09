package com.example.weatherforecast.model.fivedayweather

import com.google.gson.annotations.SerializedName
import java.io.Serializable

public class Sys: Serializable {
    @SerializedName("pod")
    var pod: String? = null

}