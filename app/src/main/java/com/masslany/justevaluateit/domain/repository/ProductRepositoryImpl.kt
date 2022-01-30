package com.masslany.justevaluateit.domain.repository

import com.masslany.justevaluateit.data.local.JEIDatabase
import com.masslany.justevaluateit.data.local.entity.Product
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    database: JEIDatabase
) : ProductRepository {

    private val productDao = database.productDao

    override fun getAllProducts(): Flow<List<Product>> {
        return productDao.getAllProducts()
    }

    override fun getRecentProducts(limit: Int): Flow<List<Product>> {
        return productDao.getRecentProducts(limit)
    }

    override suspend fun getProductByName(productName: String): List<Product> {
        return productDao.getProductByName(productName)
    }

    override suspend fun addProduct(product: Product) {
        productDao.insertProduct(product)
    }

    override suspend fun deleteProduct(product: Product) {
        productDao.deleteProduct(product)
    }
}
