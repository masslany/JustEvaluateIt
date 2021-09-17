package com.masslany.justevaluateit.domain.repository

import com.masslany.justevaluateit.data.local.entity.Product

interface ProductRepository {

    suspend fun addProduct(product: Product)
    suspend fun deleteProduct(product: Product)
}