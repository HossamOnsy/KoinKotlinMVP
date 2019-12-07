package com.example.kotlinkoinmvp.presenter

import com.sam.koinkotlinmvp.repository.CatsRepo
import com.sam.koinkotlinmvp.mvp.CatsPresenterInterface
import com.sam.koinkotlinmvp.mvp.CatsViewInterface
import com.sam.koinkotlinmvp.models.Cat

class CatsPresenterImpl constructor(var catsViewInterface: CatsViewInterface,var catsRepo : CatsRepo)  :
    CatsPresenterInterface {


    init {
        catsRepo.topCats = this
    }

    fun getCats( numberOfCatsPerCall : Int){
        catsRepo.getCats(numberOfCatsPerCall)
    }

    override fun catList(result: List<Cat>) {
        catsViewInterface.getCatList(result)
    }

}