package com.masslany.justevaluateit.domain.repository

import com.masslany.justevaluateit.data.local.JEIDatabase
import com.masslany.justevaluateit.data.local.entity.Reviewer
import kotlinx.coroutines.flow.Flow

class ReviewerRepositoryImpl(
    database: JEIDatabase
) : ReviewerRepository {

    private val reviewerDao = database.reviewerDao

    override fun getAllReviewers(): Flow<List<Reviewer>> {
        return reviewerDao.getAllReviewers()
    }

    override suspend fun addReviewer(reviewer: Reviewer) {
        reviewerDao.insertReviewer(reviewer)
    }

    override suspend fun deleteReviewer(reviewer: Reviewer) {
        reviewerDao.deleteReviewer(reviewer)
    }
}