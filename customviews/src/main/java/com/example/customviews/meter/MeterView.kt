package com.example.customviews.meter

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.customviews.CheqTextView
import com.example.customviews.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MeterView(
    context: Context,
    private val attributeSet: AttributeSet
) : LinearLayout(
    context, attributeSet
) {
    var meterText: String? = null

    var normalText: String? = null

    init {
        getCustomAttributes()
        startMeterAnimation()
    }

    private fun getCustomAttributes() {
        val customAttributes =
            context.theme.obtainStyledAttributes(attributeSet, R.styleable.MeterView, 0, 0)
        meterText = customAttributes.getString(R.styleable.MeterView_meterText)
        normalText = customAttributes.getString(R.styleable.MeterView_normalText)
        customAttributes.recycle()
    }

    private fun startMeterAnimation() {
        meterText?.let {
            val textViews = mutableListOf<CheqTextView>()
            for (i in it.indices) {
                val tv = CheqTextView(context = context, attributeSet = attributeSet).apply {
                    text = "0"
                }
                addView(tv)
                textViews.add(tv)
            }

            for (i in 0 until textViews.size) {
                CoroutineScope(Dispatchers.IO).launch {
                    for (counter in 0..9) {
                        val animDiff = if (i % 2 == 0) 10L else 0L
                        withContext(Dispatchers.Main) {
                            YoYo.with(Techniques.SlideInUp)
                                .duration(30 + animDiff)
                                .playOn(textViews[i]);
                        }
                        delay(30 + animDiff)
                        if (i == 0 && counter == it[i].toString().toInt()) {
                            withContext(Dispatchers.Main) {
                                textViews[i].text = counter.toString()
                            }
                            break
                        } else {
                            if (counter == 9) {
                                withContext(Dispatchers.Main) {
                                    textViews[i].text = it[i].toString()
                                }
                            } else {
                                withContext(Dispatchers.Main) {
                                    textViews[i].text = counter.toString()
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}