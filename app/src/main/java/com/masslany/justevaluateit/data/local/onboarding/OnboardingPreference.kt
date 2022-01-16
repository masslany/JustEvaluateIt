package com.masslany.justevaluateit.data.local.onboarding

import kotlinx.coroutines.flow.Flow


interface OnboardingPreference {

    fun isFirstLaunch(): Flow<Boolean>

    suspend fun setFirstLaunch(firstLaunch: Boolean)
}
