package com.example.common

import java.util.Currency
import java.util.Locale

/**
    Can be used to easily manage currency if CheQ goes international.
    Later on Currency from Java can be used.
 */
object Currency {
    val currentCurrency: String get() {
        return INDIAN_RUPEES
    }

    private const val INDIAN_RUPEES = "₹"
}