package com.sam.koinkotlinmvp.repository

import android.util.Log
import com.example.ainfo.utils.CatApi
import com.sam.koinkotlinmvp.mvp.CatsPresenterInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CatsRepo {

    lateinit var topCats: CatsPresenterInterface

    val catApi by lazy {
        CatApi.create()
    }

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