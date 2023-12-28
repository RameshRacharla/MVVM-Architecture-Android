package com.ramesh.baseproject.ui.splash

import com.ramesh.baseproject.data.repository.UserRepository
import com.ramesh.baseproject.ui.base.BaseViewModel
import com.ramesh.baseproject.utils.network.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
@HiltViewModel
class SplashViewModel @Inject constructor(
    networkHelper: NetworkHelper, private val userRepository: UserRepository
) : BaseViewModel(networkHelper) {

    override fun onCreate() {

    }
}