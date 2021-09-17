package com.masslany.justevaluateit.domain.usecase.onboarding

import com.masslany.justevaluateit.data.local.onboarding.OnboardingPreference
import com.masslany.justevaluateit.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateShowOnboardingUseCase @Inject constructor(
    private val onboardingPreference: OnboardingPreference,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun execute(isFirstLaunch: Boolean) {
        withContext(ioDispatcher) {
            onboardingPreference.setFirstLaunch(isFirstLaunch)
        }
    }
}