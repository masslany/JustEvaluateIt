package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.data.local.entity.Reviewer
import com.masslany.justevaluateit.domain.usecase.category.AddCategoryUseCase
import com.masslany.justevaluateit.domain.usecase.category.GetAllCategoriesUseCase
import com.masslany.justevaluateit.domain.usecase.onboarding.UpdateShowOnboardingUseCase
import com.masslany.justevaluateit.domain.usecase.reviewer.AddReviewerUseCase
import com.masslany.justevaluateit.domain.usecase.reviewer.GetAllReviewersUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class OnboardingViewModel @Inject constructor(
    private val addReviewerUseCase: AddReviewerUseCase,
    getAllReviewersUseCase: GetAllReviewersUseCase,
    private val addCategoryUseCase: AddCategoryUseCase,
    getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val updateShowOnboardingUseCase: UpdateShowOnboardingUseCase,
) {

    private val scope = CoroutineScope(SupervisorJob())

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
        scope.launch {
            updateShowOnboardingUseCase.execute(false)
        }
    }

    private fun addReviewer(reviewer: Reviewer) {
        scope.launch {
            addReviewerUseCase.execute(reviewer)
        }
    }

    private fun addCategory(category: Category) {
        scope.launch {
            addCategoryUseCase.execute(category)
        }
    }
}
