package com.example.weatherforecast.model.currentweather

import com.example.weatherforecast.model.common.Clouds
import com.example.weatherforecast.model.common.Coord
import com.example.weatherforecast.model.common.WeatherItem
import com.example.weatherforecast.model.common.Wind
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/*
 "coord":{
      "lon":-0.13,
      "lat":51.51
   },
   "weather":[
      {
         "id":300,
         "main":"Drizzle",
         "description":"light intensity drizzle",
         "icon":"09d"
      }
   ],
   "base":"stations",
   "main":{
      "temp":280.32,
      "pressure":1012,
      "humidity":81,
      "temp_min":279.15,
      "temp_max":281.15
   },
   "visibility":10000,
   "wind":{
      "speed":4.1,
      "deg":80
   },
   "clouds":{
      "all":90
   },
   "dt":1485789600,
   "sys":{
      "type":1,
      "id":5091,
      "message":0.0103,
      "country":"GB",
      "sunrise":1485762037,
      "sunset":1485794875
   },
   "id":2643743,
   "name":"London",
   "cod":200
 */
class CurrentWeatherResponse: Serializable {
    @SerializedName("dt")
    var dt = 0
    @SerializedName("coord")
    var coord: Coord? = null
    @SerializedName("weather")
    var weather: List<WeatherItem>? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("cod")
    var cod = 0
    @SerializedName("main")
    var main: Main? = null
    @SerializedName("clouds")
    var clouds: Clouds? = null
    @SerializedName("id")
    var id = 0
    @SerializedName("sys")
    var sys: Sys? = null
    @SerializedName("base")
    var base: String? = null
    @SerializedName("wind")
    var wind: Wind? = null

}