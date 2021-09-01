package com.masslany.justevaluateit.data.local.entity.dao

import androidx.room.*
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.data.local.entity.Reviewer
import com.masslany.justevaluateit.data.local.entity.relations.CategoryWithProducts
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewerDao {

//    @Query("SELECT * FROM reviewer")
//    fun getAllReviewers(): Flow<List<Reviewer>>
//
//    @Query("SELECT * FROM reviewer WHERE reviewerId = :reviewerId")
//    fun getReviewerById(reviewerId: Int): Flow<Reviewer>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertReviewer(reviewer: Reviewer)
//
//    @Update
//    fun updateReviewer(reviewer: Reviewer)
}