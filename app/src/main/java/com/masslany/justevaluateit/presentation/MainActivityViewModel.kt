package com.masslany.justevaluateit.presentation

import androidx.lifecycle.ViewModel
import com.masslany.justevaluateit.domain.usecase.onboarding.ShouldShowOnboardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    shouldShowOnboardingUseCase: ShouldShowOnboardingUseCase
) : ViewModel() {

    val shouldShowOnboarding = shouldShowOnboardingUseCase.execute()
}
