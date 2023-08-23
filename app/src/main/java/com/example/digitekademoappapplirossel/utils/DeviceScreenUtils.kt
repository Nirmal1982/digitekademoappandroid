package com.example.digitekademoappapplirossel.utils

import android.content.Context
import android.util.DisplayMetrics


object DeviceScreenUtils {
    fun getPxFromDp(context: Context, dp: Float): Int {
        return (dp * context.getResources().getDisplayMetrics().density).toInt()
    }
}