package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.data.local.entity.Reviewer
import com.masslany.justevaluateit.domain.usecase.category.AddCategoryUseCase
import com.masslany.justevaluateit.domain.usecase.category.GetAllCategoriesUseCase
import com.masslany.justevaluateit.domain.usecase.onboarding.UpdateShowOnboardingUseCase
import com.masslany.justevaluateit.domain.usecase.reviewer.AddReviewerUseCase
import com.masslany.justevaluateit.domain.usecase.reviewer.GetAllReviewersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val addReviewerUseCase: AddReviewerUseCase,
    getAllReviewersUseCase: GetAllReviewersUseCase,
    private val addCategoryUseCase: AddCategoryUseCase,
    getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val updateShowOnboardingUseCase: UpdateShowOnboardingUseCase,
) : ViewModel() {

    val reviewers = getAllReviewersUseCase.execute()

    private val _addReviewerFieldState: MutableState<String> = mutableStateOf("")
    val addReviewerFieldState: State<String> = _addReviewerFieldState

    val categories = getAllCategoriesUseCase.execute()

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

    fun onGetStartedButtonClicked() {
        viewModelScope.launch {
            updateShowOnboardingUseCase.execute(false)
        }
    }

    private fun addReviewer(reviewer: Reviewer) {
        viewModelScope.launch {
            addReviewerUseCase.execute(reviewer)
        }
    }

    private fun addCategory(category: Category) {
        viewModelScope.launch {
            addCategoryUseCase.execute(category)
        }
    }
}
