package com.example.weatherforecast.utilss

import com.example.weatherforecast.utilss.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private var retrofit: Retrofit? = null
    private const val REQUEST_TIMEOUT = 60
    private var okHttpClient: OkHttpClient? = null
    /**
     * @return retrofit instance [Retrofit]
     */
    val client: Retrofit?
        get() {
            if (okHttpClient == null) initOkHttp()
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

    /**
     * init instance of [OkHttpClient]
     */
    private fun initOkHttp() {
        val httpClient = OkHttpClient().newBuilder()
            .connectTimeout(
                REQUEST_TIMEOUT.toLong(),
                TimeUnit.SECONDS
            )
            .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
        //httpClient.addInterceptor(interceptor);
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        okHttpClient = httpClient.build()
    }
}