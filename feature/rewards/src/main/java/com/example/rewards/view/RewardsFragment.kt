package com.example.rewards.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.common.pushClickAnim.PushScale
import com.example.common.pushClickAnim.setPushClickListener
import com.example.rewards.databinding.FragmentRewardsBinding
import com.example.rewards.view.adapter.ExploreVoucherAdapter
import com.example.rewards.view.adapter.FeaturedDealAdapter
import com.example.rewards.viewmodel.RewardsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RewardsFragment : Fragment() {

    private val rewardsViewModel by viewModels<RewardsViewModel>()

    private lateinit var binding: FragmentRewardsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRewardsBinding.inflate(inflater, container, false)
        binding.rewardsViewModel = rewardsViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getVoucherCategories()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.expandedBalanceView.setPushClickListener {
            // TODO: Do anything.
        }
        binding.yourVouchers.setPushClickListener {}
        binding.getCashLayout.setPushClickListener(PushScale.VERY_LOW) {}
    }

    private fun getVoucherCategories() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                rewardsViewModel.categories.collectLatest { categories ->
                    // Ideally In a production app we would submit the list into
                    // recyclerview rather than creating adapter again and again creating adapter
                    binding.exploreVouchersRecyclerView.adapter = ExploreVoucherAdapter(categories)
                }

            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                rewardsViewModel.featuredDeal.collectLatest { featuredDeals ->
                    binding.featuredDeals.adapter = FeaturedDealAdapter(featuredDeals)
                    binding.otherFeaturedDeals.adapter = FeaturedDealAdapter(featuredDeals)
                }
            }
        }


    }

}