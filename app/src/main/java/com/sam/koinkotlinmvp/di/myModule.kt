package com.sam.koinkotlinmvp.di

import com.sam.koinkotlinmvp.networking.CatApi
import com.sam.koinkotlinmvp.repository.CatsRepo
import com.example.kotlinkoinmvp.presenter.CatsPresenterImpl
import com.sam.koinkotlinmvp.mvp.CatsViewInterface
import com.sam.koinkotlinmvp.ui.CatAdapter
import com.sam.koinkotlinmvp.utils.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val myModule = module {

    single{
        CatAdapter(arrayListOf())
    }
    single{
        createApi()
    }
    single{
        CatsRepo(get())
    }
    single{ (view: CatsViewInterface) ->  CatsPresenterImpl(view,get()) }

}

fun createApi(): CatApi {

    val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("$BASE_URL/")
        .build()

    return retrofit.create(CatApi::class.java)

}