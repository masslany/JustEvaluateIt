package com.masslany.justevaluateit.domain.usecase.onboarding

import com.masslany.justevaluateit.data.local.onboarding.OnboardingPreference
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ShouldShowOnboardingUseCase @Inject constructor(
    private val onboardingPreference: OnboardingPreference
) {
     fun execute() = runBlocking { onboardingPreference.isFirstLaunch().first() }
}
