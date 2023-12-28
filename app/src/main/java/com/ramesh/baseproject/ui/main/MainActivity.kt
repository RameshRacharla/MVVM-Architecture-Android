package com.ramesh.baseproject.ui.main

import android.os.Bundle
import android.view.View
import com.ramesh.baseproject.ui.base.BaseActivity

import androidx.activity.viewModels
import com.ramesh.baseproject.databinding.ActivitySplashBinding
import com.ramesh.baseproject.ui.main.MainViewModel
import com.ramesh.baseproject.utils.common.Toaster
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel>() {

    private val displayLength: Long = 3000
    private lateinit var binding: ActivitySplashBinding
    override val viewModel: MainViewModel by viewModels()
    override fun provideLayoutId(): View {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun setupView(savedInstanceState: Bundle?) {
        Toaster.show(this, "Welcome")
    }


}