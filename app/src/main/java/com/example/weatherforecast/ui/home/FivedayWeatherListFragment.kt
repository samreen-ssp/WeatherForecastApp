package com.example.weatherforecast.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherforecast.R
import com.example.weatherforecast.adapter.FiveDayWeatherAdapter
import com.example.weatherforecast.databinding.FragmentListBinding
import com.example.weatherforecast.model.fivedayweather.FiveDayResponse
import com.example.weatherforecast.model.fivedayweather.ItemHourly

class FivedayWeatherListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    private lateinit var weather_data : FiveDayResponse
    private val hashMap_response: HashMap<String, ArrayList<ItemHourly>> = HashMap()

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
            weather_data = arguments!!.getSerializable("data") as FiveDayResponse
            groupData()
        }

    }


    fun groupData()
    {

        for (item in weather_data.list!!) {
            val strs = item.dtTxt?.split(" ")?.toTypedArray()
            val date = strs?.get(0)
            val key: String? = date
            if (hashMap_response.containsKey(key)) {
                val list: java.util.ArrayList<ItemHourly>? = hashMap_response.get(key)
                list?.add(item)
            } else {
                val list: ArrayList<ItemHourly> = ArrayList()
                list.add(item)
                hashMap_response.put(key.toString(), list)
            }
        }

        val keyList = ArrayList(hashMap_response.keys)
        val valueList = ArrayList(hashMap_response.values)

        setRecyclerView(keyList,valueList)
    }

    private fun setRecyclerView(
        keyList: ArrayList<String>,
        valueList: ArrayList<java.util.ArrayList<ItemHourly>>
    ) {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter =
            FiveDayWeatherAdapter(
                keyList,
                valueList
            )
    }
}
