package com.example.weatherforecast.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.databinding.ItemHourForecastBinding
import com.example.weatherforecast.model.fivedayweather.ItemHourly

class HourListAdapter(
    var data: List<ItemHourly>
) : RecyclerView.Adapter<HourListAdapter.ViewHolder>() {
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
            ItemHourForecastBinding.inflate(
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

    inner class ViewHolder internal constructor(var mBinding: ItemHourForecastBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        //Using data binding
        fun bindWeatherData(data: ItemHourly) {
            if (mBinding.vm == null) {
                mBinding.vm = HourWeatherVM(data)
            } else {
                mBinding.vm?.setValue(data)
            }
        }

    }

}