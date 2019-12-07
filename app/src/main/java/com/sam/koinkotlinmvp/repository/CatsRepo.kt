package com.sam.koinkotlinmvp.repository

import android.util.Log
import com.sam.koinkotlinmvp.networking.CatApi
import com.sam.koinkotlinmvp.mvp.CatsPresenterInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CatsRepo( var catApi: CatApi) {

    lateinit var topCats: CatsPresenterInterface

    var disposable: Disposable? = null

    fun getCats(numberOfCatsPerCall: Int) {

        disposable = catApi.getCats(numberOfCatsPerCall)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    Log.v("cats", "" + result)
                    topCats.catList(result)
                },
                { error ->
                    Log.e("ERROR", error.message)
                }
            )
    }

}