package com.masslany.justevaluateit.domain.repository

import com.masslany.justevaluateit.data.local.JEIDatabase
import com.masslany.justevaluateit.data.local.entity.Reviewer

class ReviewerRepositoryImpl(
    database: JEIDatabase
) : ReviewerRepository {

    private val reviewerDao = database.reviewerDao

    override suspend fun addReviewer(reviewer: Reviewer) {
        reviewerDao.insertReviewer(reviewer)
    }

    override suspend fun deleteReviewer(reviewer: Reviewer) {
        reviewerDao.deleteReviewer(reviewer)
    }
}