package com.example.user.fuckinggreatadvicegetter.model.network

import com.example.user.fuckinggreatadvicegetter.model.Advice
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RetrofitService {
    @GET("random")
    fun getData(): Deferred<Advice>
}