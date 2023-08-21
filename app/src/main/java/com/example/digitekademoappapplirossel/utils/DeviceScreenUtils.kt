package com.example.digitekademoappapplirossel.utils

import android.content.Context
import android.util.DisplayMetrics


object DeviceScreenUtils {
    fun getPxFromDp(context: Context, dp: Float): Int {
        return Math.round(dp*(context.resources.getDisplayMetrics().ydpi/ DisplayMetrics.DENSITY_DEFAULT))
    }
}