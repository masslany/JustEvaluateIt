package com.masslany.justevaluateit.domain.usecase.reviewer

import com.masslany.justevaluateit.data.local.entity.Reviewer
import com.masslany.justevaluateit.di.IoDispatcher
import com.masslany.justevaluateit.domain.repository.ReviewerRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddReviewerUseCase @Inject constructor(
    private val reviewerRepository: ReviewerRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun execute(reviewer: Reviewer) {
        withContext(ioDispatcher) {
            reviewerRepository.addReviewer(reviewer)
        }
    }
}