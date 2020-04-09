package com.example.weatherforecast.utilss

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.example.weatherforecast.R
import com.example.weatherforecast.model.CityInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


class APPUtils {
    fun getCitiesListFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getCitiesListWithIDs(context: Context): List<CityInfo>? {
        val jsonFileString = context.let { APPUtils().getCitiesListFromAsset(it, "city.list.json") }
        val cities = Gson().fromJson<List<CityInfo>>(jsonFileString, object : TypeToken<List<CityInfo>>() {}.type)
        return cities
    }
     fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
        return activeNetworkInfo != null
    }
    fun checkIfInternetAvailable(context: Context): Boolean {
        if (isNetworkAvailable(context)) {
            try {
                val urlc: HttpURLConnection =
                    URL("https://www.google.com").openConnection() as HttpURLConnection
                urlc.setRequestProperty("User-Agent", "Test")
                urlc.setRequestProperty("Connection", "close")
                urlc.connectTimeout = 1500
                urlc.connect()
                return urlc.responseCode == 200
            } catch (e: IOException) {
                Log.e("LOG_TAG", "Error checking internet connection", e)
            }
        } else {
            Log.d("LOG_TAG", "No network available!")
        }
        return false

    }
    /**
     * Hide soft keyboard
     *
     * @param ctx
     */
    fun hideKeyboard(ctx: Context) {
        val inputManager = ctx
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        // check if no view has focus:
        val v = (ctx as Activity).currentFocus ?: return
        inputManager.hideSoftInputFromWindow(v.windowToken, 0)
    }
    /*
    var to: Move? = null   var Fragment:Next? = null
    *
    * @param parentFragment
    * @param fragmentToLoad
    * @param addToBackStack
    * @param tag
    */

    fun enterNextFragment(
        parentFragment: Fragment,
        fragmentToLoad: Fragment,
        addToBackStack: Boolean,
        tag: String?
    ) {
        val manager = parentFragment.parentFragmentManager
        val ft = manager.beginTransaction()

        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.replace(R.id.container, fragmentToLoad, tag)
        ft.commitAllowingStateLoss()
    }


}