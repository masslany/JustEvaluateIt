package com.masslany.justevaluateit.data.local.dao

import androidx.room.*
import com.masslany.justevaluateit.data.local.entity.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getAllCategories(): Flow<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)
}