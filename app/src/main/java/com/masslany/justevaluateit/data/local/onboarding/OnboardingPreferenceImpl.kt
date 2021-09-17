package com.masslany.justevaluateit.data.local.onboarding

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class OnboardingPreferenceImpl @Inject constructor(
    private val context: Context
) : OnboardingPreference {

    private companion object {
        const val ONBOARDING_DATA_STORE_NAME = "onboardingPreferences"
        val key = booleanPreferencesKey("firstLaunchKey")
    }

    private val Context.dataStore by preferencesDataStore(
        name = ONBOARDING_DATA_STORE_NAME
    )

    override fun isFirstLaunch(): Flow<Boolean> {
        return context.dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { it[key] ?: true }
    }

    override suspend fun setFirstLaunch(firstLaunch: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[key] = firstLaunch
        }
    }
}