package com.example.rewards.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.common.pushClickAnim.setPushClickListener
import com.example.rewards.databinding.ItemExploreVoucherBinding

class ExploreVoucherAdapter(
    private val categories: List<VoucherCategory>
): RecyclerView.Adapter<ExploreVoucherAdapter.ExploreVoucherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreVoucherViewHolder {
        val binding = ItemExploreVoucherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExploreVoucherViewHolder(binding)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: ExploreVoucherViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    inner class ExploreVoucherViewHolder(private val binding: ItemExploreVoucherBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(voucherCategory: VoucherCategory) {
            with(binding) {
                exploreVoucherIcon.setImageResource(voucherCategory.icon)
                exploreVoucherCategory.text = voucherCategory.title
                root.setPushClickListener {}
            }
        }
    }
}