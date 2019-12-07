package com.sam.koinkotlinmvp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinkoinmvp.presenter.CatsPresenterImpl
import com.sam.koinkotlinmvp.mvp.CatsViewInterface
import com.sam.koinkotlinmvp.R
import com.sam.koinkotlinmvp.models.Cat
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(),
    CatsViewInterface {

    // this is how the koin injects the presenter inside the activity
    val catsPresenterImpl: CatsPresenterImpl by inject()
    val catsAdapter: CatAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCats.adapter = catsAdapter
        rvCats.layoutManager = GridLayoutManager(this, 2)
        rvCats.setHasFixedSize(false)

//        catsAdapter.notifyDataSetChanged()
        catsPresenterImpl.catsViewInterface = this
        catsPresenterImpl.getCats(30)

    }

    override fun getCatList(result: List<Cat>) {
        catsAdapter.updateList(result)
        progressBar.visibility = View.INVISIBLE
    }

}




