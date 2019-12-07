package com.sam.koinkotlinmvp.networking

import com.sam.koinkotlinmvp.models.Cat
import com.sam.koinkotlinmvp.utils.BASE_URL
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("images/search")
    fun getCats(@Query("limit") limit: Int): Observable<List<Cat>>
}
