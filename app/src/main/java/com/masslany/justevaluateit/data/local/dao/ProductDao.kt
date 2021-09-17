package com.masslany.justevaluateit.data.local.dao

import androidx.room.*
import com.masslany.justevaluateit.data.local.entity.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM product ORDER BY timeAdded DESC LIMIT :limit")
    fun getRecentProducts(limit: Int): Flow<List<Product>>

    @Query("SELECT * FROM product WHERE categoryId = :categoryId")
    fun getAllProductsWithCategory(categoryId: Int): Flow<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)
}