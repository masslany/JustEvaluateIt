package com.masslany.justevaluateit.data.local.entity

import androidx.room.Entity
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.masslany.justevaluateit.data.local.entity.relations.ReviewerProductCrossRef

@Entity(
    tableName = "review"
)
data class Review(
    @PrimaryKey(autoGenerate = true)
    val reviewId: Int = 0,
    val reviewerId: Int,
    val productId: Int,
    val grade: Float
)