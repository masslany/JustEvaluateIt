package com.masslany.justevaluateit.domain.repository

import com.masslany.justevaluateit.data.local.JEIDatabase
import com.masslany.justevaluateit.data.local.entity.Category

class CategoryRepositoryImpl(
    database: JEIDatabase
) : CategoryRepository {

    private val categoryDao = database.categoryDao

    override suspend fun addCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    override suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }
}