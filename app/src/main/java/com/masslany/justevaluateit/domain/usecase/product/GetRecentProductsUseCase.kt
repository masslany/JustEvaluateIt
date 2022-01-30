package com.masslany.justevaluateit.domain.usecase.product

import com.masslany.justevaluateit.data.local.entity.Product
import com.masslany.justevaluateit.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecentProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    fun execute(limit: Int): Flow<List<Product>> = productRepository.getRecentProducts(limit)
}
