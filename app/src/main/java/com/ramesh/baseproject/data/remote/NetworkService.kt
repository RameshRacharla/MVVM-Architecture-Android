package com.ramesh.baseproject.data.remote

import com.ramesh.baseproject.data.remote.Endpoints
import com.ramesh.baseproject.data.remote.request.DataRequest
import com.ramesh.baseproject.data.remote.response.DataResponse
import retrofit2.Response
import retrofit2.http.*

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
interface NetworkService {

    @POST(Endpoints.VERSION_CHECK)
    suspend fun getData(
        @Header("Authorization") token: String, @Body request: DataRequest
    ): Response<DataResponse>

}
