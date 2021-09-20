package com.masslany.justevaluateit.di

import com.masslany.justevaluateit.data.local.JEIDatabase
import com.masslany.justevaluateit.domain.repository.CategoryRepository
import com.masslany.justevaluateit.domain.repository.CategoryRepositoryImpl
import com.masslany.justevaluateit.domain.repository.ProductRepository
import com.masslany.justevaluateit.domain.repository.ProductRepositoryImpl
import com.masslany.justevaluateit.domain.repository.ReviewerRepository
import com.masslany.justevaluateit.domain.repository.ReviewerRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCategoryRepository(
        database: JEIDatabase
    ): CategoryRepository {
        return CategoryRepositoryImpl(database)
    }

    @Provides
    @Singleton
    fun provideReviewerRepository(
        database: JEIDatabase
    ): ReviewerRepository {
        return ReviewerRepositoryImpl(database)
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        database: JEIDatabase
    ): ProductRepository {
        return ProductRepositoryImpl(database)
    }
}
