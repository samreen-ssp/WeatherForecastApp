package com.example.weatherforecast.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.databinding.ItemDayForecastBinding
import com.example.weatherforecast.model.fivedayweather.ItemHourly


class FiveDayWeatherAdapter(
    var titles: ArrayList<String>, var detailed_data: ArrayList<java.util.ArrayList<ItemHourly>>
) : RecyclerView.Adapter<FiveDayWeatherAdapter.ViewHolder>() {
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            ItemDayForecastBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.mBinding.tvDate.text=titles.get(position)
        holder.bindData(detailed_data.get(position))
    }

    inner class ViewHolder internal constructor(var mBinding: ItemDayForecastBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        //Using data binding
        fun bindData(
            list: java.util.ArrayList<ItemHourly>
        ) {
             setRecyclerView(list)
        }
        private fun setRecyclerView(list: java.util.ArrayList<ItemHourly>) {
            mBinding.recyclerView.setHasFixedSize(true)
            mBinding.recyclerView.setLayoutManager(LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false))
            mBinding.recyclerView.setAdapter(HourListAdapter(list))
        }
    }

}