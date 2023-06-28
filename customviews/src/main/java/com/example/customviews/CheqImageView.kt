package com.example.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

open class CheqImageView(
    context: Context,
    attributeSet: AttributeSet,
): AppCompatImageView(context, attributeSet) {

    fun setImageUsingUrl(url: String?, shape: ImageViewShape = ImageViewShape.RECTANGLE) {
        when(shape) {
            ImageViewShape.CIRCLE -> Glide.with(this)
                .load(url)
                .circleCrop()
                .into(this)
            ImageViewShape.RECTANGLE -> Glide.with(this)
                .load(url)
                .into(this)
        }
    }

}

@BindingAdapter("imageUrl")
fun CheqImageView.setImageUsingUrl(url: String?) {
    setImageUsingUrl(url)
}

enum class ImageViewShape {
    CIRCLE,
    RECTANGLE,
}