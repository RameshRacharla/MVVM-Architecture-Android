package com.ramesh.baseproject.utils.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
data class NetworkError(
    val status: Int = -1,
    @Expose @SerializedName("statusCode") val statusCode: String = "-1",
    @Expose @SerializedName("message") val message: String = "Something went wrong"
)