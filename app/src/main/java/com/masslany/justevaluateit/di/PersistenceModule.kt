package com.masslany.justevaluateit.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.masslany.justevaluateit.data.local.JEIDatabase
import com.masslany.justevaluateit.data.local.onboarding.OnboardingPreference
import com.masslany.justevaluateit.data.local.onboarding.OnboardingPreferenceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): JEIDatabase {
        return Room.databaseBuilder(app, JEIDatabase::class.java, "jei_db")
            .build()
    }

    @Provides
    @Singleton
    fun provideOnboardingPreference(
        @ApplicationContext context: Context
    ): OnboardingPreference = OnboardingPreferenceImpl(context)
}
