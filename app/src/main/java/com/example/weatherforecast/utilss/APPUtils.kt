package com.example.weatherforecast.utilss

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.example.weatherforecast.R
import com.example.weatherforecast.model.CityInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

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