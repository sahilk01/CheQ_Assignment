package com.example.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod

class ProfilePictureView(
    context: Context,
    attributeSet: AttributeSet,
): CheqImageView(context, attributeSet)

@BindingAdapter("setProfilePicture")
fun ProfilePictureView.setProfilePicture(imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) {
        setImageResource(com.example.palette.R.drawable.default_profile_picture)
    } else {
        setImageUsingUrl(url = imageUrl, shape = ImageViewShape.CIRCLE)
    }
}