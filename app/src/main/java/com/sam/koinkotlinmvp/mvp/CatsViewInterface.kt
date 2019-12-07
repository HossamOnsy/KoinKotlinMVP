package com.sam.koinkotlinmvp.mvp

import com.sam.koinkotlinmvp.models.Cat

interface CatsViewInterface {
    fun getCatList(result: List<Cat>)
}