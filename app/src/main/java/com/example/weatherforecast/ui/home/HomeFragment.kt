package com.example.weatherforecast.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    var binding: FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding?.vm = HomeViewModel(
            activity,
            binding,
            this
        )

        return binding?.root
    }

}
