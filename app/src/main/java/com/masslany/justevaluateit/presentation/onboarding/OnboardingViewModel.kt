package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.data.local.entity.Reviewer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor() : ViewModel() {

    private val _reviewers: MutableState<MutableList<Reviewer>> = mutableStateOf(mutableListOf())
    val reviewers: State<List<Reviewer>> = _reviewers

    private val _addReviewerFieldState: MutableState<String> = mutableStateOf("")
    val addReviewerFieldState: State<String> = _addReviewerFieldState

    private val _categories: MutableState<MutableList<Category>> = mutableStateOf(mutableListOf())
    val categories: State<List<Category>> = _categories

    private val _addCategoryFieldState: MutableState<String> = mutableStateOf("")
    val addCategoryFieldState: State<String> = _addCategoryFieldState

    fun onAddReviewerFieldChange(value: String) {
        _addReviewerFieldState.value = value
    }

    fun onAddCategoryFieldChange(value: String) {
        _addCategoryFieldState.value = value
    }

    fun onAddReviewerButtonClicked() {
        val reviewer = Reviewer(
            name = addReviewerFieldState.value,
            photo = null
        )
        addReviewer(reviewer)
        _addReviewerFieldState.value = ""
    }

    fun onAddCategoryButtonClicked() {
        val category = Category(
            name = addCategoryFieldState.value
        )
        addCategory(category)
        _addCategoryFieldState.value = ""
    }

    private fun addReviewer(reviewer: Reviewer) {
        _reviewers.value.add(reviewer)
    }

    private fun addCategory(category: Category) {
        _categories.value.add(category)
    }
}