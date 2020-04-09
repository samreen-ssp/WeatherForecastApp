package com.example.weatherforecast.ui.home

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.databinding.FragmentHomeBinding
import com.example.weatherforecast.model.CitiesListWeather
import com.example.weatherforecast.model.CityInfo
import com.example.weatherforecast.service.ApiService
import com.example.weatherforecast.utilss.APPUtils
import com.example.weatherforecast.utilss.ApiClient
import com.example.weatherforecast.utilss.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class HomeViewModel(
    val context: Context?,
    val binding: FragmentHomeBinding?,
    val parentFragment: HomeFragment
) : ViewModel() {

    private val cities = context?.let { APPUtils().getCitiesListWithIDs(it) }

    fun onItemSelection(): View.OnClickListener? {
        return View.OnClickListener {

            val strs = binding?.tvSearch?.text.toString().split(",").toTypedArray()

            if (strs.size in 3..7) {
                var ids = ""
                for (s in strs) {

                    val cityInfo = getCityID(s)
                    if (ids != "") {
                        ids = "$ids,"
                    }
                    ids += cityInfo?.id.toString()

                }

                CallAPI(ids)



            } else {
                    Toast.makeText(context, "Please enter cities between 3 - 7", Toast.LENGTH_LONG)
                        .show()

            }


        }
    }

    private fun CallAPI(ids : String) {

        val service = ApiClient.client?.create(ApiService::class.java)

        binding?.progressBar?.visibility=View.VISIBLE

        val call = Constants.API_KEY.let { it1 ->
            service?.getCurrentWeatherData(
                ids,
                it1
            )
        }
        call?.enqueue(object : Callback<CitiesListWeather> {


            override fun onFailure(call: Call<CitiesListWeather>, t: Throwable) {
                t.message
            }

            override fun onResponse(
                call: Call<CitiesListWeather>,
                response: Response<CitiesListWeather>
            ) {

                binding?.progressBar?.visibility=View.GONE


                if (response.code() == 200) {
                    val weatherResponse = response.body()!!

                    val fragmentToLoad: Fragment = CityListFragment()
                    val bundle = Bundle()
                    bundle.putSerializable("data", weatherResponse)
                    fragmentToLoad.setArguments(bundle)


                    APPUtils().enterNextFragment(
                        parentFragment,
                        fragmentToLoad,
                        true,
                        "visible_fragment"
                    )

                }

            }
        })    }


    private fun getCityID(nameOfCity: String): CityInfo? {

        val cityFounded = cities?.find {
            it.name?.trim()?.toLowerCase(Locale.ROOT) == nameOfCity.trim().toLowerCase(
                Locale.ROOT
            )
        }
        return cityFounded
    }


}



