package com.masslany.justevaluateit.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.masslany.justevaluateit.data.local.entity.Reviewer
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewerDao {

    @Query("SELECT * FROM reviewer")
    fun getAllReviewers(): Flow<List<Reviewer>>

    @Query("SELECT * FROM reviewer WHERE reviewerId = :reviewerId")
    fun getReviewerById(reviewerId: Int): Flow<Reviewer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReviewer(reviewer: Reviewer)

    @Update
    suspend fun updateReviewer(reviewer: Reviewer)

    @Delete
    suspend fun deleteReviewer(reviewer: Reviewer)
}
