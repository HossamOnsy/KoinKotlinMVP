package com.sam.koinkotlinmvp.di

import com.sam.koinkotlinmvp.repository.CatsRepo
import com.example.kotlinkoinmvp.presenter.CatsPresenterImpl
import com.sam.koinkotlinmvp.ui.CatAdapter
import org.koin.dsl.module

val myModule = module {

    single{
       CatAdapter(arrayListOf())
    }
    single{
        CatsPresenterImpl(CatsRepo())
    }
}

