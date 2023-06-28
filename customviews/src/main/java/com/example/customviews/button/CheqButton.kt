package com.example.customviews.button

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.util.AttributeSet
import com.google.android.material.button.MaterialButton

class CheqButton(
    context: Context,
    private val attributeSet: AttributeSet,
): MaterialButton(
    context,
    attributeSet
)