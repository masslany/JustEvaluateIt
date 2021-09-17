package com.masslany.justevaluateit.data.local.dao

import androidx.room.*
import com.masslany.justevaluateit.data.local.entity.Review
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewDao {

    @Query("SELECT * FROM review")
    fun getAllReviews(): Flow<List<Review>>

    @Query("SELECT * FROM review WHERE productId = :productId")
    fun getReviewsByProductId(productId: Int): Flow<List<Review>>

    @Query("SELECT * FROM review WHERE reviewerId = :reviewerId")
    fun getReviewsByReviewerId(reviewerId: Int): Flow<List<Review>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReview(reviewer: Review)

    @Update
    suspend fun updateReview(reviewer: Review)

    @Delete
    suspend fun deleteReview(reviewer: Review)
}