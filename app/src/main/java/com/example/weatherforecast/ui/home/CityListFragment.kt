package com.example.weatherforecast.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherforecast.R
import com.example.weatherforecast.adapter.CityListAdapter
import com.example.weatherforecast.databinding.FragmentListBinding
import com.example.weatherforecast.model.CitiesListWeather
import com.example.weatherforecast.model.currentweather.CurrentWeatherResponse

class CityListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    lateinit var weather_data : CitiesListWeather

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        readArguments()
        return binding.root
    }
    private fun readArguments() {
        if (arguments != null) {
            weather_data = arguments!!.getSerializable("data") as CitiesListWeather
            setRecyclerView()
        }

    }
    private fun setRecyclerView() {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.setLayoutManager(LinearLayoutManager(activity))
        binding.recyclerView.setAdapter(
            CityListAdapter(
                this,
                weather_data.list as List<CurrentWeatherResponse>
            )
        )
    }
}
