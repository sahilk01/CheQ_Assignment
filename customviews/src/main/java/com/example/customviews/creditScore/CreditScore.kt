package com.example.customviews.creditScore

data class CreditScore(
    val creditScore: Int,
    val creditSummary: String,
    val poweredByLogo: String,
) {
    companion object {
        val dummyData get() = CreditScore(
            creditScore = 799,
            creditSummary = "VERY GOOD",
            poweredByLogo = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Experian_logo.svg/2560px-Experian_logo.svg.png"
        )
    }
}
