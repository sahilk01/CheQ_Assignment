package com.example.customviews.totalDues

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.example.customviews.databinding.LayoutTotalDuesBinding

class TotalDuesView(
    context: Context,
    attributeSet: AttributeSet,
): ConstraintLayout(
    context,
    attributeSet,
) {
    init {
        setupView()
    }

    private lateinit var binding: LayoutTotalDuesBinding

    private fun setupView() {
        binding = LayoutTotalDuesBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setDues(totalDues: TotalDues) {
        with(binding) {
            meter.text = totalDues.totalDues
            cardsRecyclerView.adapter = CardDueAdapter(totalDues.cardDues)
        }
    }
}

@BindingAdapter("dues")
fun TotalDuesView.setDues(totalDues: TotalDues?) {
    totalDues?.let {
        setDues(it)
    }
}