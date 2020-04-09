package com.example.weatherforecast.ui.home.viewmodel

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.fragment.app.Fragment
import com.example.weatherforecast.MainActivity
import com.example.weatherforecast.databinding.ItemCityWeatherBinding
import com.example.weatherforecast.model.currentweather.CurrentWeatherResponse
import com.example.weatherforecast.model.fivedayweather.FiveDayResponse
import com.example.weatherforecast.service.ApiService
import com.example.weatherforecast.ui.home.FivedayWeatherListFragment
import com.example.weatherforecast.utilss.APPUtils
import com.example.weatherforecast.utilss.ApiClient
import com.example.weatherforecast.utilss.Constants
import com.tapadoo.alerter.Alerter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CityWeatherVM(
    var data: CurrentWeatherResponse,
    var parentFragment: Fragment, var context: Context,
    var mBinding: ItemCityWeatherBinding
) : BaseObservable() {
    fun setValue(value: CurrentWeatherResponse) {
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
    val name: String?
        get() = data.name.toString()

    @get:Bindable
    val wind: String?
        get() = data.wind?.speed.toString()

    @get:Bindable
    val myloc: Boolean?
        get() = MainActivity.myLoc?.contains(name.toString())

    @get:Bindable
    val desc: String?
        get() = data.weather?.get(0)?.description.toString()

    fun CallAPI() {
        val service = ApiClient.client?.create(ApiService::class.java)
        mBinding.progressBar.visibility=View.VISIBLE

        val call = Constants.API_KEY
        .let { it1 ->
            service?.getWeatherForecast5Days(
                data.id,
                it1
            )
        }
        call?.enqueue(object : Callback<FiveDayResponse> {


            override fun onFailure(call: Call<FiveDayResponse>, t: Throwable) {
                t.message
            }

            override fun onResponse(
                call: Call<FiveDayResponse>,
                response: Response<FiveDayResponse>
            ) {
                mBinding.progressBar.visibility=View.GONE

                if (response.code() == 200) {
                    val weatherResponse = response.body()!!

                    val fragmentToLoad: Fragment =
                        FivedayWeatherListFragment()
                    val bundle = Bundle()
                    bundle.putSerializable("data", weatherResponse)
                    fragmentToLoad.arguments = bundle

                    APPUtils().enterNextFragment(
                        parentFragment,
                        fragmentToLoad,
                        true,
                        "visible_fragment"
                    )

                }
            }
        })    }
    fun onItemSelection(): View.OnClickListener? {
        return View.OnClickListener {
            if(APPUtils().isNetworkAvailable(context))
            {
                CallAPI()
            }
            else
            {
                Alerter.create(context as Activity?)
                    .setTitle("Error")
                    .setText("No network available")
                    .show()
            }
        }

    }
}