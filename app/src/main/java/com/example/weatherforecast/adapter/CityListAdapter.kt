package com.example.weatherforecast.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.databinding.ItemCityWeatherBinding
import com.example.weatherforecast.model.currentweather.CurrentWeatherResponse
import com.example.weatherforecast.ui.home.viewmodel.CityWeatherVM

class CityListAdapter(
    var parentFragment: Fragment,
    var data: List<CurrentWeatherResponse>
) : RecyclerView.Adapter<CityListAdapter.ViewHolder>() {
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            ItemCityWeatherBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bindWeatherData(data[position])
    }

    inner class ViewHolder internal constructor(var mBinding: ItemCityWeatherBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        //Using data binding
        fun bindWeatherData(data: CurrentWeatherResponse?) {
            if (mBinding.vm == null) {
                mBinding.vm =
                    CityWeatherVM(
                        data!!,
                        parentFragment,itemView.context,
                        mBinding
                    )
            } else {
                mBinding.vm?.setValue(data!!)
            }
        }

    }

}