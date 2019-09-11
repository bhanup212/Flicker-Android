package com.flickerandroid.bhanu.data

import com.flickerandroid.bhanu.viewmodels.FlickerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by: Bhanu Prakash
 * Created on: 01,September,2019
 */


val viewModelModule = module {

    viewModel { FlickerViewModel() }
}

