package com.ramesh.baseproject.data.localprefs

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 *
 *  Author : @Ramesh Racharla
 *
 * */

@Singleton
class UserPreferences @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        const val KEY_USER_NAME = "PREF_KEY_USER_NAME"
        const val KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }

    fun getAccessToken(): String? = prefs.getString(KEY_ACCESS_TOKEN, "")

    fun setAccessToken(token: String) = prefs.edit().putString(KEY_ACCESS_TOKEN, token).apply()

    fun getUserName(): String? = prefs.getString(KEY_USER_NAME, null)

    fun setUserName(userName: String) = prefs.edit().putString(KEY_USER_NAME, userName).apply()


    fun clearData() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}