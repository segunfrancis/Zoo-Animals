package com.segunfrancis.zooanimals.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.segunfrancis.zooanimals.util.BASE_URL
import com.segunfrancis.zooanimals.util.NETWORK_TIMEOUT
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteModule {

    private fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().also { it.level = HttpLoggingInterceptor.Level.BODY }
    }

    private fun provideClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(provideLoggingInterceptor())
            .callTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    fun provideApi(): ZooAnimalApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .client(provideClient())
            .build()
            .create(ZooAnimalApi::class.java)
    }
}
