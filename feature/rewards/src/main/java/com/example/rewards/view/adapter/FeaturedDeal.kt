package com.example.rewards.view.adapter

import androidx.annotation.DrawableRes
import com.example.palette.R

data class FeaturedDeal(
    @DrawableRes
    val dealImage: Int
) {
    companion object {
        val dummyData get() = listOf(
            FeaturedDeal(
                dealImage = R.drawable.swiggy
            ),
            FeaturedDeal(
                dealImage = R.drawable.subway_frame
            ),
            FeaturedDeal(
                dealImage = R.drawable.swiggy
            ),
        )
    }
}
