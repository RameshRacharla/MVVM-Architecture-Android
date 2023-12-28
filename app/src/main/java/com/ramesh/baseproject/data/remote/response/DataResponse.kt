package com.ramesh.baseproject.data.remote.response

import com.google.gson.annotations.SerializedName


data class DataResponse(
    @field:SerializedName("MessageStatus")
    val MessageStatus: Int? = 0,

    @field:SerializedName("Message")
    val message: String? = null
)