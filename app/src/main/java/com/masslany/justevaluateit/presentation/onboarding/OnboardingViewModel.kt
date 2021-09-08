package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.masslany.justevaluateit.data.local.entity.Reviewer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor() : ViewModel() {

    private val _reviewers: MutableState<MutableList<Reviewer>> = mutableStateOf(mutableListOf())
    val reviewers: State<List<Reviewer>> = _reviewers

    private val _addReviewerFieldState: MutableState<String> = mutableStateOf("")
    val addReviewerFieldState: State<String> = _addReviewerFieldState

    fun onAddReviewerFieldChange(value: String) {
        _addReviewerFieldState.value = value
    }

    fun onAddReviewerButtonClicked() {
        val reviewer = Reviewer(
            name = addReviewerFieldState.value,
            photo = null
        )
        addReviewer(reviewer)
        _addReviewerFieldState.value = ""
    }

    private fun addReviewer(reviewer: Reviewer) {
        _reviewers.value.add(reviewer)
    }
}