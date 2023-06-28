package com.example.rewards.viewmodel

import androidx.lifecycle.ViewModel
import com.example.customviews.expandedChipBalance.ChipBalance
import com.example.rewards.view.adapter.FeaturedDeal
import com.example.rewards.view.adapter.VoucherCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RewardsViewModel @Inject constructor(): ViewModel() {

    private val _chipBalance = MutableStateFlow(ChipBalance.dummyData)
    val chipBalance get() = _chipBalance.asStateFlow()

    private val _categories = MutableStateFlow(VoucherCategory.dummyData)
    val categories get() = _categories.asStateFlow()

    private val _featuredDeals = MutableStateFlow(FeaturedDeal.dummyData)
    val featuredDeal get() = _featuredDeals.asStateFlow()

}