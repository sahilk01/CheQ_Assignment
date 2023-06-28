package com.example.common

import android.content.res.Resources
import android.view.View
import com.example.common.pushClickAnim.PushDownAnim
import kotlin.math.roundToInt


val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).roundToInt()

val Float.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).roundToInt()



