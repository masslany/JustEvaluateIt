package com.masslany.justevaluateit.domain.usecase.reviewer

import com.masslany.justevaluateit.data.local.entity.Reviewer
import com.masslany.justevaluateit.domain.repository.ReviewerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllReviewersUseCase @Inject constructor(
    private val reviewerRepository: ReviewerRepository
) {

    fun execute(): Flow<List<Reviewer>> = reviewerRepository.getAllReviewers()
}