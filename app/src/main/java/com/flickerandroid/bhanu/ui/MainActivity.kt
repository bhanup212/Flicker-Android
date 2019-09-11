package com.flickerandroid.bhanu.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.flickerandroid.bhanu.R
import com.flickerandroid.bhanu.viewmodels.FlickerViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {


    private val viewModel by viewModel<FlickerViewModel>()
    private lateinit var adapter:PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = PhotoAdapter()
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = GridLayoutManager(this,3)
        recyclerView.adapter = adapter
        viewModel.loadAllPhotos()
        setObservers()
    }
    private fun setObservers(){

        viewModel.isDataLoading.observe(this, Observer {
            if (it)progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE
        })
        viewModel.photos.observe(this, Observer {
            adapter.addPhotos(it)
        })
    }
}
