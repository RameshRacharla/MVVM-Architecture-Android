package com.ramesh.baseproject.utils.common

import android.content.Context
import android.widget.Toast
/**
 *
 *  Author : @Ramesh Racharla
 *
 * */
object Toaster {
    fun show(context: Context, text: CharSequence) {
        val toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
        toast.show()
    }

}