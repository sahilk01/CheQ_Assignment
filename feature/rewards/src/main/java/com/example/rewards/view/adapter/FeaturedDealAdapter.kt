package com.example.rewards.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.common.pushClickAnim.PushScale
import com.example.common.pushClickAnim.setPushClickListener
import com.example.rewards.databinding.ItemFeaturedDealBinding

class FeaturedDealAdapter(
    private val deals: List<FeaturedDeal>
): RecyclerView.Adapter<FeaturedDealAdapter.FeaturedDealViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedDealViewHolder {
        val binding = ItemFeaturedDealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeaturedDealViewHolder(binding)
    }

    override fun getItemCount(): Int = deals.size

    override fun onBindViewHolder(holder: FeaturedDealViewHolder, position: Int) {
        val deal = deals[position]
        holder.bind(deal)
    }

    inner class FeaturedDealViewHolder(private val binding: ItemFeaturedDealBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(deal: FeaturedDeal) {
            with(binding) {
                dealImage.setImageResource(deal.dealImage)
                root.setPushClickListener(pushScale = PushScale.VERY_LOW) {

                }
            }
        }
    }
}