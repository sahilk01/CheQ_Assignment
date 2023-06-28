package com.example.rewards.view.adapter

import androidx.annotation.DrawableRes
import com.example.palette.R

data class VoucherCategory(
    @DrawableRes
    val icon: Int,
    val title: String,
) {
    companion object {
        val dummyData get() = listOf(
            VoucherCategory(
                icon = R.drawable.food_category,
                title = "Food"
            ),
            VoucherCategory(
                icon = R.drawable.travel_category,
                title = "Travel"
            ),
            VoucherCategory(
                icon = R.drawable.shopping_category,
                title = "Shopping"
            ),
            VoucherCategory(
                icon = R.drawable.see_all_category,
                title = "See All"
            ),
        )
    }
}
