package com.masslany.justevaluateit.presentation.mainactivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masslany.justevaluateit.domain.usecase.onboarding.ShouldShowOnboardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    shouldShowOnboardingUseCase: ShouldShowOnboardingUseCase
) : ViewModel() {

    val shouldShowOnboarding = shouldShowOnboardingUseCase.execute()
}
