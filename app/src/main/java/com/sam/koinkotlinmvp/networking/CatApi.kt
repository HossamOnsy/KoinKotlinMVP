package com.example.ainfo.utils
import com.sam.koinkotlinmvp.utils.BASE_URL
import com.sam.koinkotlinmvp.models.Cat
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface CatApi {
        @GET("images/search")
        fun getCats(@Query("limit") limit: Int): Observable<List<Cat>>


        companion object {

            fun create(): CatApi {

                val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("$BASE_URL/")
                    .build()

                return retrofit.create(CatApi::class.java)

            }
        }

    }
