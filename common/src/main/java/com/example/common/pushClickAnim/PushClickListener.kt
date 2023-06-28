package com.example.common.pushClickAnim

import android.view.View

/**
Use this to implement push down animation on any kind of view.
Pass scale as float.. should be 1.0 to 0.01 lower the number, higher the scale.
 */

inline fun View.setPushClickListener(
    pushScale: Float = PushScale.LOW,
    crossinline view: (View) -> Unit
) {
    PushDownAnim
        .setPushDownAnimTo(this)
        .setScale(pushScale)
        ?.setOnClickListener {
            view(this)
        }
}