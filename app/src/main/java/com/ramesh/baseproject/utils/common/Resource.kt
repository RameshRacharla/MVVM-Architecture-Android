package com.ramesh.baseproject.utils.common

import java.io.Serializable

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
data class Resource<out T> private constructor(val status: Status, val data: T?) : Serializable {

    companion object {
        fun <T> success(data: T? = null): Resource<T> = Resource(Status.SUCCESS, data)

        fun <T> error(data: T? = null): Resource<T> = Resource(Status.ERROR, data)

        fun <T> loading(data: T? = null): Resource<T> = Resource(Status.LOADING, data)

        fun <T> unknown(data: T? = null): Resource<T> = Resource(Status.UNKNOWN, data)
    }
}