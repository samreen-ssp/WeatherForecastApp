package com.example.weatherforecast.ui.home.viewmodel


import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.weatherforecast.model.fivedayweather.ItemHourly



class HourWeatherVM(var data: ItemHourly) : BaseObservable() {
    fun setValue(value: ItemHourly) {
        data = value
        notifyChange()
    }


    @get:Bindable
    val tempMin: String?
        get() = data.main?.tempMin.toString()

    @get:Bindable
    val tempMax: String?
        get() = data.main?.tempMax.toString()
    @get:Bindable
    val time: String?
        get() = data.getTimeTitle().toString()

    @get:Bindable
    val wind: String?
        get() = data.wind?.speed.toString()



    @get:Bindable
    val desc: String?
        get() = data.weather?.get(0)?.description.toString()



}