package com.example.customviews.expandedChipBalance

data class ChipBalance(
    val balance: Int,
    val waitingTime: Int,
) {
    companion object {
        val dummyData get() = ChipBalance(
            balance = 2344,
            waitingTime = 800
        )
    }
}
