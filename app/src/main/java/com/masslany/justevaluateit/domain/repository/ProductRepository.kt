package com.masslany.justevaluateit.domain.repository

import com.masslany.justevaluateit.data.local.entity.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getAllProducts(): Flow<List<Product>>
    suspend fun getProductByName(productName: String): List<Product>
    suspend fun addProduct(product: Product)
    suspend fun deleteProduct(product: Product)
}
