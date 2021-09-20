package com.masslany.justevaluateit.domain.repository

import com.masslany.justevaluateit.data.local.JEIDatabase
import com.masslany.justevaluateit.data.local.entity.Category
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(
    database: JEIDatabase
) : CategoryRepository {

    private val categoryDao = database.categoryDao

    override fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAllCategories()
    }

    override suspend fun addCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    override suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }
}
