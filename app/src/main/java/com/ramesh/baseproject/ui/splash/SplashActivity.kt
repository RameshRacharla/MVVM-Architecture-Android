package com.ramesh.baseproject.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.ramesh.baseproject.ui.base.BaseActivity

import android.os.Handler
import androidx.activity.viewModels
import com.ramesh.baseproject.databinding.ActivitySplashBinding
import com.ramesh.baseproject.ui.main.MainActivity
import com.ramesh.baseproject.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
@AndroidEntryPoint
class SplashActivity : BaseActivity<MainViewModel>() {

    private val displayLength: Long = 3000
    private lateinit var binding: ActivitySplashBinding
    override val viewModel: MainViewModel by viewModels()
    override fun provideLayoutId(): View {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun setupView(savedInstanceState: Bundle?) {
        Handler(mainLooper).postDelayed(Runnable { /* Create an Intent that will start the Next - Activity. */
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, displayLength)
    }


}