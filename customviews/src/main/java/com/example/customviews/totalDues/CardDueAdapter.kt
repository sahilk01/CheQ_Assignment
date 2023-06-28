package com.example.customviews.totalDues

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.customviews.databinding.ItemCardsBinding

class CardDueAdapter(
    private val dues: List<CardDue>
) : RecyclerView.Adapter<CardDueAdapter.CardDueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDueViewHolder {
        val binding = ItemCardsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardDueViewHolder(binding)
    }

    override fun getItemCount(): Int = dues.size

    override fun onBindViewHolder(holder: CardDueViewHolder, position: Int) {
        val due = dues[position]
        holder.bind(due)
    }

    inner class CardDueViewHolder(private val binding: ItemCardsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(due: CardDue) {
            with(binding) {
                this.due = due
                when (val billingType = due.billingType) {
                    is BillingType.BillDue -> setBillDue(billingType)

                    is BillingType.NoBillFound -> setNoBillFound(billingType)
                }
            }

        }

        private fun setBillDue(billingType: BillingType.BillDue) {
            with(binding) {
                dueAmountTextView.apply {
                    visibility = View.VISIBLE
                    text = billingType.dueAmount
                }
                overdueMessage.text = billingType.overdueTime
            }
        }

        private fun setNoBillFound(billingType: BillingType.NoBillFound) {
            with(binding) {
                dueAmountTextView.visibility = View.GONE
                overdueMessage.text = billingType.message
                overdueMessage.setTextColor(
                    ContextCompat.getColor(
                        this.root.context,
                        com.example.palette.R.color.greyScaleGrey5
                    )
                )
            }
        }
    }
}