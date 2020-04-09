package com.example.weatherforecast.service

import com.example.weatherforecast.model.CitiesListWeather
import com.example.weatherforecast.model.currentweather.CurrentWeatherResponse
import com.example.weatherforecast.model.daysweather.MultipleDaysWeatherResponse
import com.example.weatherforecast.model.fivedayweather.FiveDayResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    /**
     * Get current weather of city
     *
     * @param id String id of cities
     * @param appId String api key
     * @return instance of [CurrentWeatherResponse]
     */
    @GET("data/2.5/group")
    fun getCurrentWeatherData(@Query("id") city_ids: String, @Query("appid") app_id: String):
            Call<CitiesListWeather>

    /**
     * Get five days weather forecast.

     * @param id  String id of city
     * @param appId String api key
     * @return instance of [FiveDayResponse]
     * api.openweathermap.org/data/2.5/forecast?id=524901
     */


    @GET("data/2.5/forecast")
    fun getWeatherForecast5Days(@Query("id") city_id: Int, @Query("appid") app_id: String):
            Call<FiveDayResponse>

}