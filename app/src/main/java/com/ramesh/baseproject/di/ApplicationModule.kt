package com.ramesh.baseproject.di

import android.content.Context
import android.content.SharedPreferences
import com.ramesh.baseproject.R
import com.ramesh.baseproject.data.localprefs.UserPreferences
import com.ramesh.baseproject.data.remote.Endpoints.BASEURL
import com.ramesh.baseproject.data.remote.NetworkService
import com.ramesh.baseproject.data.remote.Networking
import com.ramesh.baseproject.data.repository.UserRepository
import com.ramesh.baseproject.utils.network.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *
 *  Author : @Ramesh Racharla
 *
 * */

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {


    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            context.getString(R.string.app_name), Context.MODE_PRIVATE
        )

    @Provides
    @Singleton
    fun provideNetworkService(@ApplicationContext context: Context): NetworkService =
        Networking.createAPI(
            BASEURL, context.cacheDir, 10 * 1024 * 1024 // 10MB
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper =
        NetworkHelper(context)


    @Provides
    fun provideUserRepository(
        networkService: NetworkService, userPreferences: UserPreferences
    ): UserRepository {
        return UserRepository(networkService, userPreferences)
    }

}