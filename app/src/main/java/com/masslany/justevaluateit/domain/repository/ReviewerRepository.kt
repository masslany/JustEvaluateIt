package com.masslany.justevaluateit.domain.repository

import com.masslany.justevaluateit.data.local.entity.Reviewer
import kotlinx.coroutines.flow.Flow

interface ReviewerRepository {

    fun getAllReviewers(): Flow<List<Reviewer>>
    suspend fun addReviewer(reviewer: Reviewer)
    suspend fun deleteReviewer(reviewer: Reviewer)
}