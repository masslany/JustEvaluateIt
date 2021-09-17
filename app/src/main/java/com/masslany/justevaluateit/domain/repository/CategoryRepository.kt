package com.masslany.justevaluateit.domain.repository

import com.masslany.justevaluateit.data.local.entity.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getAllCategories(): Flow<List<Category>>
    suspend fun addCategory(category: Category)
    suspend fun deleteCategory(category: Category)
}