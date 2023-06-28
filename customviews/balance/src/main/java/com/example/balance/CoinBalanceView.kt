package com.example.balance

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.common.dp
import com.example.palette.R

class CoinBalanceView(
    context: Context,
    private val attributeSet: AttributeSet
): AppCompatTextView(
    context,
    attributeSet
) {

    companion object {
        private const val DEFAULT_BALANCE = "0"
    }

    init {
        setupView()
    }

    private var balance: String = DEFAULT_BALANCE

    private fun setupView() {
        setCustomAttributes()
        background = ContextCompat.getDrawable(context, com.example.balance.R.drawable.balance_background)
        val cheqCoin = ContextCompat.getDrawable(context, R.drawable.cheq_coin)
        setCompoundDrawablesWithIntrinsicBounds(cheqCoin, null, null, null)
        compoundDrawablePadding = 4.dp
        setBalance()
        setPadding(12.dp, 5.dp, 12.dp, 5.dp)
    }

    @SuppressLint("SetTextI18n")
    private fun setBalance() {
        text = "$balance"
        setTextAppearance(R.style.Subtitle1)
    }

    private fun setCustomAttributes() {
        val customAttributes =
            context.theme.obtainStyledAttributes(attributeSet, com.example.balance.R.styleable.CoinBalanceView, 0, 0)
        balance = customAttributes.getString(com.example.balance.R.styleable.CoinBalanceView_balance) ?: DEFAULT_BALANCE
        customAttributes.recycle()
    }
}