package com.example.customviews.expandedChipBalance

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.example.customviews.databinding.LayoutExpandedChipBalanceBinding

class ExpandedChipBalanceView(
    context: Context,
    attributes: AttributeSet
): ConstraintLayout(
    context,
    attributes
){
    init {
        setupView()
    }

    private lateinit var binding: LayoutExpandedChipBalanceBinding

    private fun setupView() {
        binding = LayoutExpandedChipBalanceBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setChipBalance(chipBalance: ChipBalance) {
        with(binding) {
            chipBalanceTextView.text = chipBalance.balance.toString()
            waitingTime.text = chipBalance.waitingTime.toString()
        }
    }
}

@BindingAdapter("balance")
fun ExpandedChipBalanceView.setBalance(chipBalance: ChipBalance) {
    setChipBalance(chipBalance)
}