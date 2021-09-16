package com.masslany.justevaluateit.domain.repository

import com.masslany.justevaluateit.data.local.entity.Reviewer

interface ReviewerRepository {

    suspend fun addReviewer(reviewer: Reviewer)
    suspend fun deleteReviewer(reviewer: Reviewer)
}