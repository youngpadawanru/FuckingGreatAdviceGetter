package com.example.user.fuckinggreatadvicegetter.model.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory {

    private const val URL = "http://fucking-great-advice.ru/api/"

    fun getService(): RetrofitService {
        return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(RetrofitService::class.java)
    }
}