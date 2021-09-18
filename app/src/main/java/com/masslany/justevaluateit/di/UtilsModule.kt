package com.masslany.justevaluateit.di

import com.masslany.justevaluateit.data.local.JEIDatabase
import com.masslany.justevaluateit.domain.validation.AddProductValidation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UtilsModule {

    @Provides
    @Singleton
    fun provideAddProductValidation(database: JEIDatabase): AddProductValidation =
        AddProductValidation(database)
}