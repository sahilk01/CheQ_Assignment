package com.example.customviews.button

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.customviews.R
import com.example.customviews.databinding.LayoutSubtextButtonBinding

class CheqSubTextButton(
    context: Context,
    private val attributeSet: AttributeSet,
) : CardView(
    context,
    attributeSet
) {
    init {
        setupView()
    }

    var text: String? = null

    var subText: String? = null

    var subTextIcon: Drawable? = null

    var subTextColor: Int? = null

    var textColor: Int? = null

    private lateinit var binding: LayoutSubtextButtonBinding

    private fun setupView() {
        binding = LayoutSubtextButtonBinding.inflate(LayoutInflater.from(context), this, true)
        getCustomAttributes()
        setCustomAttributes()
    }

    private fun getCustomAttributes() {
        val customAttributes =
            context.theme.obtainStyledAttributes(attributeSet, R.styleable.CheqSubTextButton, 0, 0)
        text = customAttributes.getString(R.styleable.CheqSubTextButton_text)
        subText = customAttributes.getString(R.styleable.CheqSubTextButton_subtext)
        subTextIcon = customAttributes.getDrawable(R.styleable.CheqSubTextButton_subtextIcon)
        textColor = customAttributes.getColor(
            R.styleable.CheqSubTextButton_textColor,
            ContextCompat.getColor(context, com.example.palette.R.color.greyScale)
        )
        subTextColor = customAttributes.getColor(
            R.styleable.CheqSubTextButton_subtextColor,
            ContextCompat.getColor(context, com.example.palette.R.color.greyScale)
        )
        customAttributes.recycle()
    }

    private fun setCustomAttributes() {
        with(binding) {
            textview.text = text
            subtTextview.text = subText
            textColor?.let {
                textview.setTextColor(it)
            }
            subTextColor?.let {
                subtTextview.setTextColor(it)
            }
            subTextIcon.setImageDrawable(this@CheqSubTextButton.subTextIcon)
        }
    }

}