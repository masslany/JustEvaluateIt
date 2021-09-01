package com.masslany.justevaluateit.data.local.entity.dao

import androidx.room.*
import com.masslany.justevaluateit.data.local.entity.Product
import com.masslany.justevaluateit.data.local.entity.relations.CategoryWithProducts
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM product ORDER BY timeAdded DESC LIMIT :limit")
    fun getRecentProducts(limit: Int): Flow<List<Product>>

    @Transaction
    @Query("SELECT * FROM product WHERE categoryId = :categoryId")
    fun getAllProductsWithCategory(categoryId: Int): Flow<List<CategoryWithProducts>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Update
    fun updateProduct(product: Product)
}