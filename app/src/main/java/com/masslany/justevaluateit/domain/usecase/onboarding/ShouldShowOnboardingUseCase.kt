package com.masslany.justevaluateit.domain.usecase.onboarding

import com.masslany.justevaluateit.data.local.onboarding.OnboardingPreference
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShouldShowOnboardingUseCase @Inject constructor(
    private val onboardingPreference: OnboardingPreference
) {
    fun execute(): Flow<Boolean> = onboardingPreference.isFirstLaunch()
}
