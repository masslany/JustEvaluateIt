package com.masslany.justevaluateit.domain.repository

import com.masslany.justevaluateit.data.local.entity.Category

interface CategoryRepository {

    suspend fun addCategory(category: Category)
    suspend fun deleteCategory(category: Category)
}