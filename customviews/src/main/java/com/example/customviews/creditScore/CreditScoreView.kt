package com.example.customviews.creditScore

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.example.customviews.databinding.LayoutCreditScoreBinding

class CreditScoreView(
    context: Context,
    attributes: AttributeSet
): ConstraintLayout(
    context,
    attributes
) {

    init {
        setupView()
    }

    private lateinit var binding: LayoutCreditScoreBinding

    private fun setupView() {
        binding = LayoutCreditScoreBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setCreditScoreData(creditScore: CreditScore) {
        with(binding) {
            poweredByLogo.setImageUsingUrl(creditScore.poweredByLogo)
            creditScoreTextView.text = creditScore.creditScore.toString()
            creditScoreResult.text = creditScore.creditSummary
        }
    }

}

@BindingAdapter("creditScore")
fun CreditScoreView.setCreditScore(creditScore: CreditScore) {
    setCreditScoreData(creditScore)
}