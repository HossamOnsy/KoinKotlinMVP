package com.sam.koinkotlinmvp.mvp

import com.sam.koinkotlinmvp.models.Cat

interface CatsPresenterInterface {
    fun catList(result: List<Cat>)
}