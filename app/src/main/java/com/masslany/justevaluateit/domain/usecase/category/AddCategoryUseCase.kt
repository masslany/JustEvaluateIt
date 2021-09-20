package com.masslany.justevaluateit.domain.usecase.category

import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.di.IoDispatcher
import com.masslany.justevaluateit.domain.repository.CategoryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddCategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun execute(category: Category) {
        withContext(ioDispatcher) {
            categoryRepository.addCategory(category)
        }
    }
}
