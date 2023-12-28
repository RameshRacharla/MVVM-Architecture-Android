package com.ramesh.baseproject.data.repository

import com.ramesh.baseproject.data.localprefs.UserPreferences
import com.ramesh.baseproject.data.remote.NetworkService
import com.ramesh.baseproject.data.remote.request.DataRequest
import com.ramesh.baseproject.data.remote.response.DataResponse
import retrofit2.Response
import javax.inject.Inject

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */

class UserRepository @Inject constructor(
    private val networkService: NetworkService, private val userPreferences: UserPreferences
) {

    fun saveAccessToken(token: String) {
        userPreferences.setAccessToken(token)
    }

    fun getAccessToken(): String? {
        return userPreferences.getAccessToken()
    }


    suspend fun getData(
        Authorization: String, str: String
    ): Response<DataResponse> {
        return networkService.getData(
            Authorization, DataRequest(str)
        )
    }


}