package com.masslany.justevaluateit.domain.usecase.category

import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {

    fun execute(): Flow<List<Category>> = categoryRepository.getAllCategories()
}
