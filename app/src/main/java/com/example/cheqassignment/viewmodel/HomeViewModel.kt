package com.example.cheqassignment.viewmodel

import androidx.lifecycle.ViewModel
import com.example.customviews.creditScore.CreditScore
import com.example.customviews.totalDues.TotalDues
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _profilePicture = MutableStateFlow("")
    val profilePicture get() = _profilePicture.asStateFlow()

    private val _totalDues = MutableStateFlow(TotalDues.dummyData)
    val totalDues get() = _totalDues.asStateFlow()

    private val _creditScore = MutableStateFlow(CreditScore.dummyData)
    val creditScore get() = _creditScore.asStateFlow()

}